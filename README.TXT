PROJECT TITLE: Duck Hunter
PURPOSE OF PROJECT: To semi-accurately simulate a duck hunting game using physics and probablility.
VERSION or DATE: 1.0.0
HOW TO START THIS PROJECT: Run "Runner.java"
AUTHORS: Serge Zvenigorodsky
USER INSTRUCTIONS: Run "Runner.java"


***********************************************************************************************************************
**                                                               DOCUMENTATION                                                                                **
***********************************************************************************************************************

OBJECTS:
*************************************************
Runner: Runs the program.

Drawer: Draws the screen.

Voxel: 3-D pixel. Volumiferous.

ThreeDGrid: 3-dimensional array of voxels.

Locatable: Interface for objects that have a location in the ThreeDGrid.

    MovingObj: Abstract object that defines a moving object's referance voxel, (see ALGORITHMS for more detail on referance 
                       voxels) and velocity vector given by the origin voxel and another voxel. Implements Locatable.
                       
                Duck: Locatable object that starts far from the origin, with an initial velocity. It can change it's velocity. 
                          It is shot at by Gun with Shot. Depending on whether or not it's hit in the wings or the body it has a respectively
                          lower or higher chance of falling. Extends MovingObj.
                          
                Shot: Locatable object that appears at the tip of the gun, with a very large initial velocity and very large initial density.
                         Has a gauge, and a shot size, which help determine it's properties as it flies. As it flies forward, it travels in 
                         accordance with the laws of physics, losing altitude, changing it's velocity, increasing it's spread, increasing it's 
                         length, and changing it's density. Density may also be different at different points in the shot cloud. When it 
                         collides with a duck the duck may or may not fall to the ground. (See ALGORITHMS for more detail on 
                         the processes behind shot hitting the duck. ) Extends MovingObj.
                         
                Gun: Locatable object. Has a gauge, a choke type, and a firing speed (timePerShot). In the first iteration, it will only be 
                        able to change the direction it's poining, in later iterations it may be able to change it's location. Fires the shot, 
                        which appears at it's tip. Can only fire shots of its' gauge. Extends MovingObj.
                        
ALGORITHMS:
************************************************
Referance Voxels: Every MovingObj type object has a referance voxel. This Voxel's location is defined absolutely, relative
                             to the origin of the 3 dimensional grid represented by the array of Voxels in ThreeDGrid. The MovingObj
                             type object has stores all the locations of it's voxels relative to it's referance voxel. All the absolute voxel
                             locations (relative to the origin of the 3 dimensional grid in ThreeDGrid) can be calculated with the help of
                             this referance voxel.

Handling Hits and Misses: Whether or not a shot hits a duck is determined with the help of probabilistic calculations. If 
                                          Voxels of the Shot object and the Duck object intersect, the density of the shot is used to calculate
                                          the locations of the individual pellets. Then, where the duck is hit is determined. If it is hit in the
                                          wings, it has to be hit by a given weight of pellets to fall. If it is hit in the body, it has to be hit by a 
                                          different weight of pellets to fall. If it is hit in the neck, it has to be hit by one more different
                                          weight of pellets to fall. If it is hit in the head, one pellet of any size will make it fall.The weight 
                                          has to be calculated for other regions of the duck's body because pellets differ in size.
            