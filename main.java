import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

class GUI implements ActionListener{
        //=======================//


    static int[] dijkstra(int src, int V)
    {
        final int[][] g =  {{1, 2451, 713, 10180, 1631, 13, 2408, 213, 2571, 875, 1420, 2145, 19720},
                {2451, 0, 1745, 1524, 831, 1240, 959, 2596, 403, 1589, 1374, 357, 579},
                {713, 1745, 0, 355, 920, 803, 1737, 851, 1858, 262, 940, 1453, 1260},
                {10180, 1524, 355, 0, 700, 862, 1395, 1123, 1584, 466, 1056, 1280, 987},
                {1631, 831, 920, 700, 0, 63, 1021, 1769, 949, 796, 87, 586, 371},
                {13, 1240, 803, 862, 66, 0, 1681, 1551, 1765, 547, 225, 887, 99},
                {2408, 959, 1737, 1395, 1021, 1681, 0, 2493, 678, 1724, 1891, 1114, 701},
                {213, 2596, 851, 1123, 1769, 1551, 2493, 0, 2699, 1038, 1605, 2300, 2099},
                {2571, 403, 1858, 1584, 949, 1765, 678, 2699, 0, 1744, 1645, 653, 600},
                {875, 1589, 262, 466, 796, 547, 1724, 1038, 1744, 0, 679, 1272, 1162},
                {1420, 1374, 940, 1056, 87, 225, 1891, 1605, 1645, 679, 0, 1017, 1200},
                {2145, 357, 1453, 1280, 586, 887, 1114, 2300, 653, 1272, 1017, 0, 504},
                {19720, 579, 1260, 987, 371, 99, 701, 2099, 600, 1162, 1200, 504, 0},
        };
        // Write your code here
        int dist[] = new int[V];
        Boolean visited[] = new Boolean[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        Arrays.fill(visited,false);
        dist[src]=0;
        for(int i=0;i<V-1;i++){
            int p= minDistance(dist,visited,V);
            visited[p]=true;
            for(int j=0;j<V;j++){
                if(!visited[j]&&g[p][j]!=0&&dist[p]!=Integer.MAX_VALUE&& dist[p]+g[p][j]<dist[j]){
                    dist[j]=dist[p]+g[p][j];
                }
            }

        }
        return dist;

    }

    static int minDistance(int dist[], Boolean visited[],int V)
    {
        int minD=Integer.MAX_VALUE;
        int minInd=-1;

        for(int k=0;k<V;k++){
            if(!visited[k]&&dist[k]<minD){
                minD=dist[k];
                minInd=k;
            }

        }
        return minInd;
    }

//==============//
    static HashSet<Integer> dis=new HashSet<>();
    static ArrayList<Integer>paths=new ArrayList<>();
    private static final int NO_PARENT = -1;
    //===============================//

    public static void dijkstra_path( int startVertex, HashSet<Integer> hs )
    {
        int[][] adjacencyMatrix =  {{0, 2451, 713, 10180, 1631, 13, 2408, 213, 2571, 875, 1420, 2145, 19720},
                {2451, 0, 1745, 1524, 831, 1240, 959, 2596, 403, 1589, 1374, 357, 579},
                {713, 1745, 0, 355, 920, 803, 1737, 851, 1858, 262, 940, 1453, 1260},
                {10180, 1524, 355, 0, 700, 862, 1395, 1123, 1584, 466, 1056, 1280, 987},
                {1631, 831, 920, 700, 0, 63, 1021, 1769, 949, 796, 87, 586, 371},
                {13, 1240, 803, 862, 66, 0, 1681, 1551, 1765, 547, 225, 887, 99},
                {2408, 959, 1737, 1395, 1021, 1681, 0, 2493, 678, 1724, 1891, 1114, 701},
                {213, 2596, 851, 1123, 1769, 1551, 2493, 0, 2699, 1038, 1605, 2300, 2099},
                {2571, 403, 1858, 1584, 949, 1765, 678, 2699, 0, 1744, 1645, 653, 600},
                {875, 1589, 262, 466, 796, 547, 1724, 1038, 1744, 0, 679, 1272, 1162},
                {1420, 1374, 940, 1056, 87, 225, 1891, 1605, 1645, 679, 0, 1017, 1200},
                {2145, 357, 1453, 1280, 586, 887, 1114, 2300, 653, 1272, 1017, 0, 504},
                {19720, 579, 1260, 987, 371, 99, 701, 2099, 600, 1162, 1200, 504, 0},
        };
        int nVertices = adjacencyMatrix[0].length;

        // shortestDistances[i] will hold the
        // shortest distance from src to i
        int[] shortestDistances = new int[nVertices];

        // added[i] will true if vertex i is
        // included / in shortest path tree
        // or shortest distance from src to
        // i is finalized
        boolean[] added = new boolean[nVertices];

        // Initialize all distances as
        // INFINITE and added[] as false
        for (int vertexIndex = 0; vertexIndex < nVertices;
             vertexIndex++)
        {
            shortestDistances[vertexIndex] = Integer.MAX_VALUE;
            added[vertexIndex] = false;
        }

        // Distance of source vertex from
        // itself is always 0
        shortestDistances[startVertex] = 0;

        // Parent array to store shortest
        // path tree
        int[] parents = new int[nVertices];

        // The starting vertex does not
        // have a parent
        parents[startVertex] = NO_PARENT;

        // Find shortest path for all
        // vertices
        for (int i = 1; i < nVertices; i++)
        {

            // Pick the minimum distance vertex
            // from the set of vertices not yet
            // processed. nearestVertex is
            // always equal to startNode in
            // first iteration.
            int nearestVertex = -1;
            int shortestDistance = Integer.MAX_VALUE;
            for (int vertexIndex = 0;
                 vertexIndex < nVertices;
                 vertexIndex++)
            {
                if (!added[vertexIndex] &&
                        shortestDistances[vertexIndex] <
                                shortestDistance)
                {
                    nearestVertex = vertexIndex;
                    shortestDistance = shortestDistances[vertexIndex];
                }
            }

            // Mark the picked vertex as
            // processed
            added[nearestVertex] = true;

            // Update dist value of the
            // adjacent vertices of the
            // picked vertex.
            for (int vertexIndex = 0;
                 vertexIndex < nVertices;
                 vertexIndex++)
            {
                int edgeDistance = adjacencyMatrix[nearestVertex][vertexIndex];

                if (edgeDistance > 0
                        && ((shortestDistance + edgeDistance) <
                        shortestDistances[vertexIndex]))
                {
                    parents[vertexIndex] = nearestVertex;
                    shortestDistances[vertexIndex] = shortestDistance +
                            edgeDistance;
                }
            }
        }

        printSolution(startVertex, shortestDistances, parents,hs);
    }

    private static void printSolution(int startVertex, int[] distances,int[] parents ,HashSet<Integer> hs ) {

        // A utility function to print
        // the constructed distances
        // array and shortest paths

        int nVertices = distances.length;
       // System.out.print("Vertex\t Distance\tPath");

        for (int vertexIndex = 0;
             vertexIndex < nVertices;
             vertexIndex++) {
            if (vertexIndex != startVertex && hs.contains(vertexIndex)) {
               // System.out.print("\n" + startVertex + " -> ");
           //     System.out.print(vertexIndex + " \t\t ");
                dis.add(distances[vertexIndex]);
                //System.out.print(distances[vertexIndex] + "\t\t");

                paths.add(-1);
                printPath(vertexIndex, parents);
            }
        }
    }
    private static void printPath(int currentVertex, int[] parents)
    {

        // Base case : Source node has
        // been processed
        if (currentVertex == NO_PARENT)
        {
            return;
        }
        paths.add(currentVertex);

        printPath(parents[currentVertex], parents);
       // System.out.print(currentVertex + " ");
    }


    //gui
    //=====================//
    private static JButton button;
    private static JTextField userText;
    private static JLabel  success;
    private static JLabel success_2;
    private static JLabel success_3;
    private static JFrame frame;
    private static JLabel success_2_2;
    private static JButton clear;

    public static void main(String args[]) {
        int i, j, k, l, m;
        JPanel panel = new JPanel();
        frame = new JFrame();
        frame.setSize(1230, 760);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(panel);
        panel.setLayout(null);
        JLabel label_1 = new JLabel("WELCOME TO THE TRAVEL PLANER");
        label_1.setBounds(190, 1, 1000, 100);
        label_1.setFont(label_1.getFont().deriveFont(45.0f));
        JLabel label_2 = new JLabel("PLEASE SELECT CITIES WHERE YOU AND YOUR FRIENDS LIVE");
        label_2.setBounds(70, 70, 8000, 90);
        label_2.setFont(label_2.getFont().deriveFont(35.0f));

        JLabel label_4 = new JLabel("please select your current location followed by your friends location. input the number corresponding to the city :) ");
        label_4.setBounds(70, 120, 8000, 90);
        label_4.setFont(label_4.getFont().deriveFont(21.0f));

        JLabel label_5 = new JLabel("0-New York 1-Los Angeles  2-Chicago 3- Minneapolis 4-Denver  ");
        label_5.setBounds(70, 190, 800, 50);
        label_5.setFont(label_5.getFont().deriveFont(20.0f));
        JLabel label_6 = new JLabel("5-Dallas 6-Seattle 7-Boston 8-San Francisco ");
        label_6.setBounds(70, 230, 800, 50);
        label_6.setFont(label_6.getFont().deriveFont(20.0f));
        JLabel label_7 = new JLabel("9-St. Louis 10-Houston 11-Phoenix 12-Salt Lake City");
        label_7.setBounds(70, 270, 800, 50);
        label_7.setFont(label_7.getFont().deriveFont(20.0f));

        panel.add(label_1);
        panel.add(label_2);
        panel.add(label_4);
        panel.add(label_5);
        panel.add(label_6);
        panel.add(label_7);
        userText = new JTextField(20);
        userText.setBounds(70, 330, 195, 40);
        userText.setFont((userText.getFont().deriveFont(22.0f)));
        ;
        panel.add(userText);
        button = new JButton("submit");
        button.setBounds(70, 370, 100, 35);
        button.setFont((button.getFont().deriveFont(16.0f)));
        ;
        button.addActionListener(new GUI());
        panel.add(button);

        success = new JLabel("");
        success.setBounds(70, 410, 800, 24);
        success.setFont((success.getFont().deriveFont(16.0f)));
        panel.add(success);

        success_2 = new JLabel("");
        success_2.setBounds(70, 375, 500, 250);
        success_2.setSize(500, 350);
        success_2.setFont((success_2.getFont().deriveFont(16.0f)));
        panel.add(success_2);

        success_2_2 = new JLabel("");
        success_2_2.setBounds(550, 375, 500, 250);
        success_2_2.setSize(500, 350);
        success_2_2.setFont((success_2_2.getFont().deriveFont(16.0f)));
        panel.add(success_2_2);

        success_3 = new JLabel("");
        success_3.setBounds(70, 699, 1000, 15);
        success_3.setFont((success_3.getFont().deriveFont(16.0f)));
        panel.add(success_3);

        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        HashMap<Integer,String > hm=new HashMap<>();
        hm.put(0,"New York");hm.put( 1,"Los Angeles ");hm.put(2,"Chicago");hm.put( 3," Minneapolis");
        hm.put( 4,"Denver");hm.put(5,"Dallas");hm.put(6, "Seattle");hm.put(7, "Boston");
        hm.put(8,"San Francisco");hm.put(9, "St. Louis");hm.put(10, "Houston");
        hm.put( 11, "Phoenix");hm.put(12,"Salt Lake City");

        String user=userText.getText();
        int V=13;
        String meh[]=user.split(" ");
        //input yours and friend's cities
        HashSet<Integer> friends=new HashSet<>();//fix the input
        for(int o=0;o<meh.length;o++) {
            friends.add(Integer.parseInt(meh[o]));
        }

        System.out.println(friends);
        //the total distance//
        int total=Integer.MAX_VALUE;
        //the index of  destination  city
        int index=0;
        //checking fro every possible city
        for(int i=0;i<V;i++) {
            int sum = 0;//current combine distance from city b to every friends city
            int[] res = dijkstra(i, V);//distance from city b to all cities
            for (int b = 0; b < V; b++) {

                if (friends.contains(b)) {
                    sum += res[b];
                }
            }

            if (sum < total) {
              // System.out.println(sum);
                total = sum;
                index = i;
            }
        }


        dijkstra_path(index, friends);
        //System.out.println(dis);

        String s="";
        String s2="";
        int i=0;
        for(int q=0;q<paths.size();q++){
            if(paths.get(q)==-1){i++;}

            if(i<=5){
            if(paths.get(q)==-1){
                if(s!=""){s=s.substring(0,s.length()-5);}
                s+="<html><br/>Path from "+hm.get(paths.get(q+1)) +" to "+hm.get(index) + " is<br/>";}
            else{
                s=s+ hm.get(paths.get(q)) +" --> ";}
        }

        else{
                if(paths.get(q)==-1){
                    if(s2!=""){s2=s2.substring(0,s2.length()-5);}
                    s2+="<html><br/>Path from "+hm.get(paths.get(q+1)) +" to "+hm.get(index) + " is<br/>";}
                else{
                    s2=s2+ hm.get(paths.get(q)) +" --> ";}

            }

        }
        s=s.substring(0,s.length()-5);
        s2=s2.substring(0,s2.length()-5);
        s+="<br/></html>";
        s2+="<br/></html>";
      //  success_2.setSize(1000,50);
        System.out.println(s);
        System.out.println(s2);
       System.out.println(paths);
        success_2.setText(s);
        success_2_2.setText(s2);
        System.out.println(friends);
            if(friends.contains(index)){

                success_3.setText("Friend at "+hm.get(index)+" don't need to move :)");
            }



        success.setText("You guys should meet at "+hm.get(index)+" as it will be closer for all of you guys, and the distance will be "+total+" KMs");
          //  System.out.println(" you guys should meet at "+hm.get(index)+" as it will be closer for all of you guys, and the distance will be "+total+" KMs");
    s="";
    }
}

