//https://leetcode.com/problems/course-schedule-ii/

package graph;

import java.util.ArrayList;
import java.util.Stack;

public class CourseSchedule_II {

   static ArrayList<Integer>[] adjacents=null;

    boolean checkForCycle(int courses, int[][] dependency)
    {
        adjacents= new ArrayList[courses];

        for(int i = 0; i <courses ; ++i)
            adjacents[i]= new ArrayList<>();

        for (int [] pre:dependency)
            adjacents[pre[0]].add(pre[1]);
         int[] visited= new int[courses];
         for (int i=0;i<courses;++i){
             if (visited[i]==0 && !dfs(adjacents,visited,i)) return false;
         }
        return true;
    }

    private boolean dfs(ArrayList<Integer>[] adjacents, int[] visited, int i) {
        if(visited[i]==1) return false;
        visited[i]=1;
        for (int adj:adjacents[i])
            if (!dfs(adjacents,visited,adj)) return false;
        visited[i]=2;
        return true;
    }

    //topological sort
    Stack<Integer> getSequence(ArrayList<Integer>[] adjacent,int courses, int [] visited, Stack<Integer> result)
    {
        for (int i=0;i<courses;++i)
            if( visited[i] == 0 ) getSequenceHelper(adjacent,visited,result,i);

        return result;
    }

    void getSequenceHelper(ArrayList<Integer>[] adjacent, int[] visited, Stack<Integer> result, int i)
    {
        for (int adj:adjacent[i])
            if (visited[adj]==0)
                getSequenceHelper(adjacent,visited,result,adj);

        visited[i]=1;
        result.push(i);
    }
    public static void main(String[] args) {
        int[][] dependency={{0,2},{0,3},{3,1},{4,2},{4,1},{5,0},{5,2}};
        CourseSchedule_II courseSchedule_ii = new CourseSchedule_II();

        Stack<Integer> result=new Stack<>();
        if (courseSchedule_ii.checkForCycle(6,dependency));
            result=courseSchedule_ii.getSequence(adjacents,6, new int[6],new Stack<>());

            while (!result.isEmpty())
                System.out.println(result.pop());
    }
}
