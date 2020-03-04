# hoover
#### A rest service that navigates a hoover through a room based on:
-	room dimensions as X and Y coordinates, identifying the top right corner of the room rectangle. This room is splitt up in a grid based on these dimensions; a room that has dimensions X: 5 and Y: 5 has 5 columns and 5 rows, so 25 possible hoover positions. The bottom left corner(X:0, Y:0) is the point of origin for our coordinate system.
-	locations of patches of dirt, also defined by X and Y coordinates identifying the bottom left corner of those grid positions.
-	an initial hoover position (X and Y coordinates)
-	driving instructions (as cardinal directions where e.g. N - "go north", E - "go east", S - "go south", W - "go west")


####	Sample json input:
{
  "roomSize" : [5, 5],
  "coords" : [1, 2],
  "patches" : [
    [1, 0],
    [2, 2],
    [2, 3]
  ],
  "instructions" : "NNESEESWNWW"
}

●	roomSize - room dimension
●	coords -  robot start position(coordinates)
●	patches - describe location(coordinates) of dirts
●	instructions  - driving instruction

●	Sample json output
{
  "coords" : [1, 3],
  "patches" : 1
}

●	coords  - final robot position
●	patches - number of cleaned patches

The room will be rectangular, has no obstacles except the room walls. All locations in the room will be clean except for the locations of the patches of dirt presented in the program input.
Placing the hoover on a patch of dirt removes the patch of dirt so that patch is then clean for the remainder of the program run. 



## Currently service is running on 8081 port

To test the functionality, you can hit http://localhost:8081/swagger-ui.html#/Hoover/CleanRoom or use postman


## Assumption

In case if Hoover is already at the end of the asix/coordinates and still it gets the instruction to move.
Hoover will ignore the instruction and there will not be any change in his coordinates.
