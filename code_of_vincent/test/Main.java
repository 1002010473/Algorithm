package test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: 文琛
 * @time: 2020/8/15 19:29
 */
public class Main{
    public static void main(String args[]){
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()){
            WorkflowNode node = WorkflowNode.load(cin.next());
            int res = method(node);
            System.out.println(res);
        }
    }
    public static int method(WorkflowNode node){
        if(node == null) return 0;
        int value = node.timeoutMillis;
        if(node.nextNodes == null) return value;
        int sub = 0;
        for(WorkflowNode n : node.nextNodes){
            sub = Math.max(sub, method(n));
        }
        return value + sub;
    }
}
class WorkflowNode {
    String nodeId;
    int timeoutMillis;
    List<WorkflowNode> nextNodes;
    boolean initialised;

    public static WorkflowNode load(String value) {
        // Create head node;
        Map<String, WorkflowNode> map = new HashMap<>();
        WorkflowNode head = new WorkflowNode("HEAD", 0, null);
        map.put(head.nodeId, head);

        for (String nodeValue : value.split("\\|")) {
            String[] properties = nodeValue.split("\\`");
            WorkflowNode node = map.get(properties[0]);

            node.timeoutMillis = Integer.parseInt(properties[1]);
            node.initialised = true;

            // Check next nodes
            if (properties[2].equals("END")) {
                continue;
            }
            node.nextNodes = Arrays.stream(properties[2].split(","))
                    .map(p -> new WorkflowNode(p, 0, null))
                    .collect(Collectors.toList());
            node.nextNodes.forEach(p -> map.put(p.nodeId, p));

            map.put(node.nodeId, node);
        }

        return head;
    }

    public WorkflowNode(String nodeId, int timeoutMillis, List<WorkflowNode> nextNodes) {
        this.nodeId = nodeId;
        this.timeoutMillis = timeoutMillis;
        this.nextNodes = nextNodes;
    }
}
