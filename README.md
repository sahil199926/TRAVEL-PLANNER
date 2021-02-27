
![](IMAGES/gifff.gif)

# TRAVEL-PLANNER

  A program which help to find the best destination to meet your friends based on the minimum distance as possible.

![](IMAGES/Capture.png)


# ALGORITHMS
dijkstra algorithm is used as a core algorithm with some minor tweaks to meet the desirable output.

# WORKING
just put your location followed by for friends location.

select the cities from the map shown and input the adjcent number.

below is shown the distance from each city to every city.

![](IMAGES/Capture_3.png)

# OUTPUT
The output consists of:-

The destination city which will be closer for all all of your friends including you.

The path for each person from their city to destination (the shortest path).


![](IMAGES/Capture_2.png)
# TIME COMPLEXITY
The time complexity of Discastra algorithm is O(E(V-1)), E being no.of edges and V being no. of connections.
but here we need to check for every vertesis if the combine distance is minimum to other possible vertices.
so we will check for every vertesis 
combine the time complexity becomes O(E(V)*V).
afer finding the destination we will print all the paths from every friends location to destination .
the effective time-complexity will be O(E(V)*V) + O(V + E) 
