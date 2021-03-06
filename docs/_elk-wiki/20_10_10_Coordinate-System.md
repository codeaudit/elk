---
layout: wiki
title: Coordinate System
type: wiki
parent: Graph Data Structure
---
When talking about the layout of a graph, we have to agree on how coordinates of graph elements are to be stored and interpreted. For the ELK graph, this is how it works:

![Coordinate system reference](graphics/layout-reference-points.png)

The coordinates of most elements are relative to their parent element. There are a few exceptions:

* Edge labels are relative to the coordinate system their edge is relative to.
* Source points, bend points, and target points of edges are relative to the edge's containing node. Following the usual containment conventions (as implemented in `ElkGraphUtil`) results in what is displayed in the image above.
