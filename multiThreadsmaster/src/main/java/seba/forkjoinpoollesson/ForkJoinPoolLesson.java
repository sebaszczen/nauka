package seba.forkjoinpoollesson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class ForkJoinPoolLesson {

    private String xx = "xx";

     protected String name = "xx";

    public static void main(String[] args) {
        System.out.println("start");
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        TreeNode treeNode = new TreeNode(2,
                new TreeNode(8),
                new TreeNode(13),
                new TreeNode(7, new TreeNode(5), new TreeNode(5)));
        Integer invoke = forkJoinPool.invoke(new CountingTask(treeNode));
        System.out.println("suma = "+invoke);
        System.out.println("end");
    }

     protected String getName() {
         return name;
     }

     static class TreeNode {
         private int value;
         private List<TreeNode> treeNodeList;

         Executor executor = Executors.newFixedThreadPool(4);

         public TreeNode(int value, TreeNode... treeNodeList) {
             this.value = value;
             this.treeNodeList = Arrays.asList(treeNodeList);
         }

     }

    static class CountingTask extends RecursiveTask<Integer> {

        private TreeNode node;

        public CountingTask(TreeNode node) {
            this.node = node;
        }

        @Override
        protected Integer compute() {
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+ " computing value, current value: "+node.value);
            if (node.treeNodeList.isEmpty()) {
                return node.value;
            } else {
                List<CountingTask> countingTasks = new ArrayList<>();
                for (TreeNode treeNode : node.treeNodeList) {
                    countingTasks.add( new CountingTask(treeNode));
                }
                for (CountingTask countingTask : countingTasks) {
                    countingTask.fork();
                }
                Integer sum = node.value;
                for (CountingTask countingTask : countingTasks) {
                    sum += countingTask.join();
                }
                return sum;
            }
        }
    }

 }

