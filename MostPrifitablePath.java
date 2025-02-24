public class MostProfitablePath {
    int maxScore=Integer.MIN_VALUE;
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n=amount.length;
        ArrayList<Integer>[] neighbours=new ArrayList[n];
        for(int i=0;i<n;i++)
        {
            neighbours[i]=new ArrayList<>();
        }
        for(int[] edge:edges){
            int a=edge[0];
            int b=edge[1];
            neighbours[a].add(b);
            neighbours[b].add(a);
        }
        int[] visitedTimeB=new int[n];
        Arrays.fill(visitedTimeB,-1);
        bobTurn(neighbours,0,bob,visitedTimeB);
//     System.out.println(Arrays.toString(visitedTimeB));
        boolean[] isVisited=new boolean[n];
        aliceTurn(neighbours,0,0,visitedTimeB,isVisited,amount,0);
        return maxScore;
    }
    boolean bobTurn(ArrayList<Integer>[] neighbours,int count,int index,int[] visitedTimeB)
    {
        if(visitedTimeB[index]!=-1) return false;
        visitedTimeB[index]=count;
        if(index==0) return true;
        for(Integer neighbour:neighbours[index])
        {
            if(bobTurn(neighbours,count+1,neighbour,visitedTimeB)) return true;
        }
        visitedTimeB[index]=-1;
        return false;
    }
    void aliceTurn(ArrayList<Integer>[] neighbours,int count,int index,int[] visitedTimeB,boolean[] isVisited,int[] amount,int score)
    {
        if(isVisited[index]) return;
        isVisited[index]=true;
        int val=0;
        if(visitedTimeB[index]==-1 || visitedTimeB[index]>count) val=amount[index];
        else if(visitedTimeB[index]==count) val=amount[index]/2;
        score+=val;
        if(index!=0&&neighbours[index].size()==1) {
//            System.out.println(score);
            maxScore=Math.max(score,maxScore);
            return;
        }
        for(Integer neighbour:neighbours[index])
        {
            aliceTurn(neighbours,count+1,neighbour,visitedTimeB,isVisited,amount,score);
        }
        isVisited[index]=false;
    }