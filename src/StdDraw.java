<html>
<head>
<title>StdDraw.java</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style type="text/css">
.s0 { color: #5f826b; font-style: italic;}
.s1 { color: #bcbec4;}
.s2 { color: #cf8e6d;}
.s3 { color: #bcbec4;}
.s4 { color: #67a37c; font-style: italic;}
.s5 { color: #68a67e; font-style: italic;}
.s6 { color: #2aacb8;}
.s7 { color: #7a7e85;}
.s8 { color: #6aab73;}
</style>
</head>
<body bgcolor="#1e1f22">
<table CELLSPACING=0 CELLPADDING=5 COLS=1 WIDTH="100%" BGCOLOR="#606060" >
<tr><td><center>
<font face="Arial, Helvetica" color="#000000">
StdDraw.java</font>
</center></td></tr></table>
<pre><span class="s0">/******************************************************************************</span>
 <span class="s0">*  Compilation:  javac StdDraw.java</span>
 <span class="s0">*  Execution:    java StdDraw</span>
 <span class="s0">*  Dependencies: none</span>
 <span class="s0">*</span>
 <span class="s0">*  Standard drawing library. This class provides a basic capability for</span>
 <span class="s0">*  creating drawings with your programs. It uses a simple graphics model that</span>
 <span class="s0">*  allows you to create drawings consisting of points, lines, and curves</span>
 <span class="s0">*  in a window on your computer and to save the drawings to a file.</span>
 <span class="s0">*</span>
 <span class="s0">*  Todo</span>
 <span class="s0">*  ----</span>
 <span class="s0">*    -  Add support for gradient fill, etc.</span>
 <span class="s0">*    -  Fix setCanvasSize() so that it can only be called once.</span>
 <span class="s0">*    -  On some systems, drawing a line (or other shape) that extends way</span>
 <span class="s0">*       beyond canvas (e.g., to infinity) dimensions does not get drawn.</span>
 <span class="s0">*</span>
 <span class="s0">*  Remarks</span>
 <span class="s0">*  -------</span>
 <span class="s0">*    -  don't use AffineTransform for rescaling since it inverts</span>
 <span class="s0">*       images and strings</span>
 <span class="s0">*</span>
 <span class="s0">******************************************************************************/</span>

<span class="s2">import </span><span class="s1">java</span><span class="s3">.</span><span class="s1">awt</span><span class="s3">.</span><span class="s1">BasicStroke</span><span class="s3">;</span>
<span class="s2">import </span><span class="s1">java</span><span class="s3">.</span><span class="s1">awt</span><span class="s3">.</span><span class="s1">Color</span><span class="s3">;</span>
<span class="s2">import </span><span class="s1">java</span><span class="s3">.</span><span class="s1">awt</span><span class="s3">.</span><span class="s1">Component</span><span class="s3">;</span>
<span class="s2">import </span><span class="s1">java</span><span class="s3">.</span><span class="s1">awt</span><span class="s3">.</span><span class="s1">FileDialog</span><span class="s3">;</span>
<span class="s2">import </span><span class="s1">java</span><span class="s3">.</span><span class="s1">awt</span><span class="s3">.</span><span class="s1">Font</span><span class="s3">;</span>
<span class="s2">import </span><span class="s1">java</span><span class="s3">.</span><span class="s1">awt</span><span class="s3">.</span><span class="s1">FontMetrics</span><span class="s3">;</span>
<span class="s2">import </span><span class="s1">java</span><span class="s3">.</span><span class="s1">awt</span><span class="s3">.</span><span class="s1">Graphics</span><span class="s3">;</span>
<span class="s2">import </span><span class="s1">java</span><span class="s3">.</span><span class="s1">awt</span><span class="s3">.</span><span class="s1">Graphics2D</span><span class="s3">;</span>
<span class="s2">import </span><span class="s1">java</span><span class="s3">.</span><span class="s1">awt</span><span class="s3">.</span><span class="s1">Image</span><span class="s3">;</span>
<span class="s2">import </span><span class="s1">java</span><span class="s3">.</span><span class="s1">awt</span><span class="s3">.</span><span class="s1">MediaTracker</span><span class="s3">;</span>
<span class="s2">import </span><span class="s1">java</span><span class="s3">.</span><span class="s1">awt</span><span class="s3">.</span><span class="s1">RenderingHints</span><span class="s3">;</span>
<span class="s2">import </span><span class="s1">java</span><span class="s3">.</span><span class="s1">awt</span><span class="s3">.</span><span class="s1">Toolkit</span><span class="s3">;</span>

<span class="s2">import </span><span class="s1">java</span><span class="s3">.</span><span class="s1">awt</span><span class="s3">.</span><span class="s1">event</span><span class="s3">.</span><span class="s1">ActionEvent</span><span class="s3">;</span>
<span class="s2">import </span><span class="s1">java</span><span class="s3">.</span><span class="s1">awt</span><span class="s3">.</span><span class="s1">event</span><span class="s3">.</span><span class="s1">ActionListener</span><span class="s3">;</span>
<span class="s2">import </span><span class="s1">java</span><span class="s3">.</span><span class="s1">awt</span><span class="s3">.</span><span class="s1">event</span><span class="s3">.</span><span class="s1">MouseEvent</span><span class="s3">;</span>
<span class="s2">import </span><span class="s1">java</span><span class="s3">.</span><span class="s1">awt</span><span class="s3">.</span><span class="s1">event</span><span class="s3">.</span><span class="s1">MouseListener</span><span class="s3">;</span>
<span class="s2">import </span><span class="s1">java</span><span class="s3">.</span><span class="s1">awt</span><span class="s3">.</span><span class="s1">event</span><span class="s3">.</span><span class="s1">MouseMotionListener</span><span class="s3">;</span>
<span class="s2">import </span><span class="s1">java</span><span class="s3">.</span><span class="s1">awt</span><span class="s3">.</span><span class="s1">event</span><span class="s3">.</span><span class="s1">KeyEvent</span><span class="s3">;</span>
<span class="s2">import </span><span class="s1">java</span><span class="s3">.</span><span class="s1">awt</span><span class="s3">.</span><span class="s1">event</span><span class="s3">.</span><span class="s1">KeyListener</span><span class="s3">;</span>

<span class="s2">import </span><span class="s1">java</span><span class="s3">.</span><span class="s1">awt</span><span class="s3">.</span><span class="s1">geom</span><span class="s3">.</span><span class="s1">Arc2D</span><span class="s3">;</span>
<span class="s2">import </span><span class="s1">java</span><span class="s3">.</span><span class="s1">awt</span><span class="s3">.</span><span class="s1">geom</span><span class="s3">.</span><span class="s1">Ellipse2D</span><span class="s3">;</span>
<span class="s2">import </span><span class="s1">java</span><span class="s3">.</span><span class="s1">awt</span><span class="s3">.</span><span class="s1">geom</span><span class="s3">.</span><span class="s1">GeneralPath</span><span class="s3">;</span>
<span class="s2">import </span><span class="s1">java</span><span class="s3">.</span><span class="s1">awt</span><span class="s3">.</span><span class="s1">geom</span><span class="s3">.</span><span class="s1">Line2D</span><span class="s3">;</span>
<span class="s2">import </span><span class="s1">java</span><span class="s3">.</span><span class="s1">awt</span><span class="s3">.</span><span class="s1">geom</span><span class="s3">.</span><span class="s1">Rectangle2D</span><span class="s3">;</span>

<span class="s2">import </span><span class="s1">java</span><span class="s3">.</span><span class="s1">awt</span><span class="s3">.</span><span class="s1">image</span><span class="s3">.</span><span class="s1">BufferedImage</span><span class="s3">;</span>
<span class="s2">import </span><span class="s1">java</span><span class="s3">.</span><span class="s1">awt</span><span class="s3">.</span><span class="s1">image</span><span class="s3">.</span><span class="s1">DirectColorModel</span><span class="s3">;</span>
<span class="s2">import </span><span class="s1">java</span><span class="s3">.</span><span class="s1">awt</span><span class="s3">.</span><span class="s1">image</span><span class="s3">.</span><span class="s1">WritableRaster</span><span class="s3">;</span>

<span class="s2">import </span><span class="s1">java</span><span class="s3">.</span><span class="s1">io</span><span class="s3">.</span><span class="s1">File</span><span class="s3">;</span>
<span class="s2">import </span><span class="s1">java</span><span class="s3">.</span><span class="s1">io</span><span class="s3">.</span><span class="s1">IOException</span><span class="s3">;</span>

<span class="s2">import </span><span class="s1">java</span><span class="s3">.</span><span class="s1">net</span><span class="s3">.</span><span class="s1">MalformedURLException</span><span class="s3">;</span>
<span class="s2">import </span><span class="s1">java</span><span class="s3">.</span><span class="s1">net</span><span class="s3">.</span><span class="s1">URL</span><span class="s3">;</span>

<span class="s2">import </span><span class="s1">java</span><span class="s3">.</span><span class="s1">util</span><span class="s3">.</span><span class="s1">LinkedList</span><span class="s3">;</span>
<span class="s2">import </span><span class="s1">java</span><span class="s3">.</span><span class="s1">util</span><span class="s3">.</span><span class="s1">TreeSet</span><span class="s3">;</span>
<span class="s2">import </span><span class="s1">java</span><span class="s3">.</span><span class="s1">util</span><span class="s3">.</span><span class="s1">NoSuchElementException</span><span class="s3">;</span>
<span class="s2">import </span><span class="s1">javax</span><span class="s3">.</span><span class="s1">imageio</span><span class="s3">.</span><span class="s1">ImageIO</span><span class="s3">;</span>

<span class="s2">import </span><span class="s1">javax</span><span class="s3">.</span><span class="s1">swing</span><span class="s3">.</span><span class="s1">ImageIcon</span><span class="s3">;</span>
<span class="s2">import </span><span class="s1">javax</span><span class="s3">.</span><span class="s1">swing</span><span class="s3">.</span><span class="s1">JFrame</span><span class="s3">;</span>
<span class="s2">import </span><span class="s1">javax</span><span class="s3">.</span><span class="s1">swing</span><span class="s3">.</span><span class="s1">JLabel</span><span class="s3">;</span>
<span class="s2">import </span><span class="s1">javax</span><span class="s3">.</span><span class="s1">swing</span><span class="s3">.</span><span class="s1">JMenu</span><span class="s3">;</span>
<span class="s2">import </span><span class="s1">javax</span><span class="s3">.</span><span class="s1">swing</span><span class="s3">.</span><span class="s1">JMenuBar</span><span class="s3">;</span>
<span class="s2">import </span><span class="s1">javax</span><span class="s3">.</span><span class="s1">swing</span><span class="s3">.</span><span class="s1">JMenuItem</span><span class="s3">;</span>
<span class="s2">import </span><span class="s1">javax</span><span class="s3">.</span><span class="s1">swing</span><span class="s3">.</span><span class="s1">KeyStroke</span><span class="s3">;</span>

<span class="s0">/**</span>
 <span class="s0">*  The {</span><span class="s4">@code </span><span class="s0">StdDraw} class provides a basic capability for</span>
 <span class="s0">*  creating drawings with your programs. It uses a simple graphics model that</span>
 <span class="s0">*  allows you to create drawings consisting of points, lines, squares,</span>
 <span class="s0">*  circles, and other geometric shapes in a window on your computer and</span>
 <span class="s0">*  to save the drawings to a file. Standard drawing also includes</span>
 <span class="s0">*  facilities for text, color, pictures, and animation, along with</span>
 <span class="s0">*  user interaction via the keyboard and mouse.</span>
 <span class="s0">*  </span><span class="s5">&lt;p&gt;</span>
 <span class="s0">*  </span><span class="s5">&lt;b&gt;</span><span class="s0">Getting started.</span><span class="s5">&lt;/b&gt;</span>
 <span class="s0">*  To use this class, you must have {</span><span class="s4">@code </span><span class="s0">StdDraw.class} in your</span>
 <span class="s0">*  Java classpath. If you used our autoinstaller, you should be all set.</span>
 <span class="s0">*  Otherwise, either download</span>
 <span class="s0">*  </span><span class="s5">&lt;a href = &quot;https://introcs.cs.princeton.edu/java/code/stdlib.jar&quot;&gt;</span><span class="s0">stdlib.jar</span><span class="s5">&lt;/a&gt;</span>
 <span class="s0">*  and add to your Java classpath or download</span>
 <span class="s0">*  </span><span class="s5">&lt;a href = &quot;https://introcs.cs.princeton.edu/java/stdlib/StdDraw.java&quot;&gt;</span><span class="s0">StdDraw.java</span><span class="s5">&lt;/a&gt;</span>
 <span class="s0">*  and put a copy in your working directory.</span>
 <span class="s0">*  </span><span class="s5">&lt;p&gt;</span>
 <span class="s0">*  Now, type the following short program into your editor:</span>
 <span class="s0">*  </span><span class="s5">&lt;pre&gt;</span>
 <span class="s0">*   public class TestStdDraw {</span>
 <span class="s0">*       public static void main(String[] args) {</span>
 <span class="s0">*           StdDraw.setPenRadius(0.05);</span>
 <span class="s0">*           StdDraw.setPenColor(StdDraw.BLUE);</span>
 <span class="s0">*           StdDraw.point(0.5, 0.5);</span>
 <span class="s0">*           StdDraw.setPenColor(StdDraw.MAGENTA);</span>
 <span class="s0">*           StdDraw.line(0.2, 0.2, 0.8, 0.2);</span>
 <span class="s0">*       }</span>
 <span class="s0">*   }</span>
 <span class="s0">*  </span><span class="s5">&lt;/pre&gt;</span>
 <span class="s0">*  If you compile and execute the program, you should see a window</span>
 <span class="s0">*  appear with a thick magenta line and a blue point.</span>
 <span class="s0">*  This program illustrates the two main types of methods in standard</span>
 <span class="s0">*  drawing—methods that draw geometric shapes and methods that</span>
 <span class="s0">*  control drawing parameters.</span>
 <span class="s0">*  The methods {</span><span class="s4">@code </span><span class="s0">StdDraw.line()} and {</span><span class="s4">@code </span><span class="s0">StdDraw.point()}</span>
 <span class="s0">*  draw lines and points; the methods {</span><span class="s4">@code </span><span class="s0">StdDraw.setPenRadius()}</span>
 <span class="s0">*  and {</span><span class="s4">@code </span><span class="s0">StdDraw.setPenColor()} control the line thickness and color.</span>
 <span class="s0">*  </span><span class="s5">&lt;p&gt;</span>
 <span class="s0">*  </span><span class="s5">&lt;b&gt;</span><span class="s0">Points and lines.</span><span class="s5">&lt;/b&gt;</span>
 <span class="s0">*  You can draw points and line segments with the following methods:</span>
 <span class="s0">*  </span><span class="s5">&lt;ul&gt;</span>
 <span class="s0">*  </span><span class="s5">&lt;li&gt; </span><span class="s0">{</span><span class="s4">@link </span><span class="s0">#point(double x, double y)}</span>
 <span class="s0">*  </span><span class="s5">&lt;li&gt; </span><span class="s0">{</span><span class="s4">@link </span><span class="s0">#line(double x1, double y1, double x2, double y2)}</span>
 <span class="s0">*  </span><span class="s5">&lt;/ul&gt;</span>
 <span class="s0">*  </span><span class="s5">&lt;p&gt;</span>
 <span class="s0">*  The </span><span class="s5">&lt;em&gt;</span><span class="s0">x</span><span class="s5">&lt;/em&gt;</span><span class="s0">- and </span><span class="s5">&lt;em&gt;</span><span class="s0">y</span><span class="s5">&lt;/em&gt;</span><span class="s0">-coordinates must be in the drawing area</span>
 <span class="s0">*  (between 0 and 1 and by default) or the points and lines will not be visible.</span>
 <span class="s0">*  </span><span class="s5">&lt;p&gt;</span>
 <span class="s0">*  </span><span class="s5">&lt;b&gt;</span><span class="s0">Squares, circles, rectangles, and ellipses.</span><span class="s5">&lt;/b&gt;</span>
 <span class="s0">*  You can draw squares, circles, rectangles, and ellipses using</span>
 <span class="s0">*  the following methods:</span>
 <span class="s0">*  </span><span class="s5">&lt;ul&gt;</span>
 <span class="s0">*  </span><span class="s5">&lt;li&gt; </span><span class="s0">{</span><span class="s4">@link </span><span class="s0">#circle(double x, double y, double radius)}</span>
 <span class="s0">*  </span><span class="s5">&lt;li&gt; </span><span class="s0">{</span><span class="s4">@link </span><span class="s0">#ellipse(double x, double y, double semiMajorAxis, double semiMinorAxis)}</span>
 <span class="s0">*  </span><span class="s5">&lt;li&gt; </span><span class="s0">{</span><span class="s4">@link </span><span class="s0">#square(double x, double y, double halfLength)}</span>
 <span class="s0">*  </span><span class="s5">&lt;li&gt; </span><span class="s0">{</span><span class="s4">@link </span><span class="s0">#rectangle(double x, double y, double halfWidth, double halfHeight)}</span>
 <span class="s0">*  </span><span class="s5">&lt;/ul&gt;</span>
 <span class="s0">*  </span><span class="s5">&lt;p&gt;</span>
 <span class="s0">*  All of these methods take as arguments the location and size of the shape.</span>
 <span class="s0">*  The location is always specified by the </span><span class="s5">&lt;em&gt;</span><span class="s0">x</span><span class="s5">&lt;/em&gt;</span><span class="s0">- and </span><span class="s5">&lt;em&gt;</span><span class="s0">y</span><span class="s5">&lt;/em&gt;</span><span class="s0">-coordinates</span>
 <span class="s0">*  of its </span><span class="s5">&lt;em&gt;</span><span class="s0">center</span><span class="s5">&lt;/em&gt;</span><span class="s0">.</span>
 <span class="s0">*  The size of a circle is specified by its radius and the size of an ellipse is</span>
 <span class="s0">*  specified by the lengths of its semi-major and semi-minor axes.</span>
 <span class="s0">*  The size of a square or rectangle is specified by its half-width or half-height.</span>
 <span class="s0">*  The convention for drawing squares and rectangles is parallel to those for</span>
 <span class="s0">*  drawing circles and ellipses, but may be unexpected to the uninitiated.</span>
 <span class="s0">*  </span><span class="s5">&lt;p&gt;</span>
 <span class="s0">*  The methods above trace outlines of the given shapes. The following methods</span>
 <span class="s0">*  draw filled versions:</span>
 <span class="s0">*  </span><span class="s5">&lt;ul&gt;</span>
 <span class="s0">*  </span><span class="s5">&lt;li&gt; </span><span class="s0">{</span><span class="s4">@link </span><span class="s0">#filledCircle(double x, double y, double radius)}</span>
 <span class="s0">*  </span><span class="s5">&lt;li&gt; </span><span class="s0">{</span><span class="s4">@link </span><span class="s0">#filledEllipse(double x, double y, double semiMajorAxis, double semiMinorAxis)}</span>
 <span class="s0">*  </span><span class="s5">&lt;li&gt; </span><span class="s0">{</span><span class="s4">@link </span><span class="s0">#filledSquare(double x, double y, double radius)}</span>
 <span class="s0">*  </span><span class="s5">&lt;li&gt; </span><span class="s0">{</span><span class="s4">@link </span><span class="s0">#filledRectangle(double x, double y, double halfWidth, double halfHeight)}</span>
 <span class="s0">*  </span><span class="s5">&lt;/ul&gt;</span>
 <span class="s0">*  </span><span class="s5">&lt;p&gt;</span>
 <span class="s0">*  </span><span class="s5">&lt;b&gt;</span><span class="s0">Circular arcs.</span><span class="s5">&lt;/b&gt;</span>
 <span class="s0">*  You can draw circular arcs with the following method:</span>
 <span class="s0">*  </span><span class="s5">&lt;ul&gt;</span>
 <span class="s0">*  </span><span class="s5">&lt;li&gt; </span><span class="s0">{</span><span class="s4">@link </span><span class="s0">#arc(double x, double y, double radius, double angle1, double angle2)}</span>
 <span class="s0">*  </span><span class="s5">&lt;/ul&gt;</span>
 <span class="s0">*  </span><span class="s5">&lt;p&gt;</span>
 <span class="s0">*  The arc is from the circle centered at (</span><span class="s5">&lt;em&gt;</span><span class="s0">x</span><span class="s5">&lt;/em&gt;</span><span class="s0">, </span><span class="s5">&lt;em&gt;</span><span class="s0">y</span><span class="s5">&lt;/em&gt;</span><span class="s0">) of the specified radius.</span>
 <span class="s0">*  The arc extends from angle1 to angle2. By convention, the angles are</span>
 <span class="s0">*  </span><span class="s5">&lt;em&gt;</span><span class="s0">polar</span><span class="s5">&lt;/em&gt; </span><span class="s0">(counterclockwise angle from the </span><span class="s5">&lt;em&gt;</span><span class="s0">x</span><span class="s5">&lt;/em&gt;</span><span class="s0">-axis)</span>
 <span class="s0">*  and represented in degrees. For example, {</span><span class="s4">@code </span><span class="s0">StdDraw.arc(0.0, 0.0, 1.0, 0, 90)}</span>
 <span class="s0">*  draws the arc of the unit circle from 3 o'clock (0 degrees) to 12 o'clock (90 degrees).</span>
 <span class="s0">*  </span><span class="s5">&lt;p&gt;</span>
 <span class="s0">*  </span><span class="s5">&lt;b&gt;</span><span class="s0">Polygons.</span><span class="s5">&lt;/b&gt;</span>
 <span class="s0">*  You can draw polygons with the following methods:</span>
 <span class="s0">*  </span><span class="s5">&lt;ul&gt;</span>
 <span class="s0">*  </span><span class="s5">&lt;li&gt; </span><span class="s0">{</span><span class="s4">@link </span><span class="s0">#polygon(double[] x, double[] y)}</span>
 <span class="s0">*  </span><span class="s5">&lt;li&gt; </span><span class="s0">{</span><span class="s4">@link </span><span class="s0">#filledPolygon(double[] x, double[] y)}</span>
 <span class="s0">*  </span><span class="s5">&lt;/ul&gt;</span>
 <span class="s0">*  </span><span class="s5">&lt;p&gt;</span>
 <span class="s0">*  The points in the polygon are ({</span><span class="s4">@code </span><span class="s0">x[i]}, {</span><span class="s4">@code </span><span class="s0">y[i]}).</span>
 <span class="s0">*  For example, the following code fragment draws a filled diamond</span>
 <span class="s0">*  with vertices (0.1, 0.2), (0.2, 0.3), (0.3, 0.2), and (0.2, 0.1):</span>
 <span class="s0">*  </span><span class="s5">&lt;pre&gt;</span>
 <span class="s0">*   double[] x = { 0.1, 0.2, 0.3, 0.2 };</span>
 <span class="s0">*   double[] y = { 0.2, 0.3, 0.2, 0.1 };</span>
 <span class="s0">*   StdDraw.filledPolygon(x, y);</span>
 <span class="s0">*  </span><span class="s5">&lt;/pre&gt;</span>
 <span class="s0">*  </span><span class="s5">&lt;p&gt;</span>
 <span class="s0">*  </span><span class="s5">&lt;b&gt;</span><span class="s0">Pen size.</span><span class="s5">&lt;/b&gt;</span>
 <span class="s0">*  The pen is circular, so that when you set the pen radius to </span><span class="s5">&lt;em&gt;</span><span class="s0">r</span><span class="s5">&lt;/em&gt;</span>
 <span class="s0">*  and draw a point, you get a circle of radius </span><span class="s5">&lt;em&gt;</span><span class="s0">r</span><span class="s5">&lt;/em&gt;</span><span class="s0">. Also, lines are</span>
 <span class="s0">*  of thickness 2</span><span class="s5">&lt;em&gt;</span><span class="s0">r</span><span class="s5">&lt;/em&gt; </span><span class="s0">and have rounded ends. The default pen radius</span>
 <span class="s0">*  is 0.005 and is not affected by coordinate scaling. This default pen</span>
 <span class="s0">*  radius is about 1/200 the width of the default canvas, so that if</span>
 <span class="s0">*  you draw 100 points equally spaced along a horizontal or vertical line,</span>
 <span class="s0">*  you will be able to see individual circles, but if you draw 200 such</span>
 <span class="s0">*  points, the result will look like a line.</span>
 <span class="s0">*  </span><span class="s5">&lt;ul&gt;</span>
 <span class="s0">*  </span><span class="s5">&lt;li&gt; </span><span class="s0">{</span><span class="s4">@link </span><span class="s0">#setPenRadius(double radius)}</span>
 <span class="s0">*  </span><span class="s5">&lt;/ul&gt;</span>
 <span class="s0">*  </span><span class="s5">&lt;p&gt;</span>
 <span class="s0">*  For example, {</span><span class="s4">@code </span><span class="s0">StdDraw.setPenRadius(0.025)} makes</span>
 <span class="s0">*  the thickness of the lines and the size of the points to be five times</span>
 <span class="s0">*  the 0.005 default.</span>
 <span class="s0">*  To draw points with the minimum possible radius (one pixel on typical</span>
 <span class="s0">*  displays), set the pen radius to 0.0.</span>
 <span class="s0">*  </span><span class="s5">&lt;p&gt;</span>
 <span class="s0">*  </span><span class="s5">&lt;b&gt;</span><span class="s0">Pen color.</span><span class="s5">&lt;/b&gt;</span>
 <span class="s0">*  All geometric shapes (such as points, lines, and circles) are drawn using</span>
 <span class="s0">*  the current pen color. By default, it is black.</span>
 <span class="s0">*  You can change the pen color with the following methods:</span>
 <span class="s0">*  </span><span class="s5">&lt;ul&gt;</span>
 <span class="s0">*  </span><span class="s5">&lt;li&gt; </span><span class="s0">{</span><span class="s4">@link </span><span class="s0">#setPenColor(int red, int green, int blue)}</span>
 <span class="s0">*  </span><span class="s5">&lt;li&gt; </span><span class="s0">{</span><span class="s4">@link </span><span class="s0">#setPenColor(Color color)}</span>
 <span class="s0">*  </span><span class="s5">&lt;/ul&gt;</span>
 <span class="s0">*  </span><span class="s5">&lt;p&gt;</span>
 <span class="s0">*  The first method allows you to specify colors using the RGB color system.</span>
 <span class="s0">*  This </span><span class="s5">&lt;a href = &quot;http://johndyer.name/lab/colorpicker/&quot;&gt;</span><span class="s0">color picker</span><span class="s5">&lt;/a&gt;</span>
 <span class="s0">*  is a convenient way to find a desired color.</span>
 <span class="s0">*  The second method allows you to specify colors using the</span>
 <span class="s0">*  {</span><span class="s4">@link </span><span class="s0">Color} data type that is discussed in Chapter 3. Until then,</span>
 <span class="s0">*  you can use this method with one of these predefined colors in standard drawing:</span>
 <span class="s0">*  {</span><span class="s4">@link </span><span class="s0">#BLACK}, {</span><span class="s4">@link </span><span class="s0">#BLUE}, {</span><span class="s4">@link </span><span class="s0">#CYAN}, {</span><span class="s4">@link </span><span class="s0">#DARK_GRAY}, {</span><span class="s4">@link </span><span class="s0">#GRAY},</span>
 <span class="s0">*  {</span><span class="s4">@link </span><span class="s0">#GREEN}, {</span><span class="s4">@link </span><span class="s0">#LIGHT_GRAY}, {</span><span class="s4">@link </span><span class="s0">#MAGENTA}, {</span><span class="s4">@link </span><span class="s0">#ORANGE},</span>
 <span class="s0">*  {</span><span class="s4">@link </span><span class="s0">#PINK}, {</span><span class="s4">@link </span><span class="s0">#RED}, {</span><span class="s4">@link </span><span class="s0">#WHITE}, {</span><span class="s4">@link </span><span class="s0">#YELLOW},</span>
 <span class="s0">*  {</span><span class="s4">@link </span><span class="s0">#BOOK_BLUE}, {</span><span class="s4">@link </span><span class="s0">#BOOK_LIGHT_BLUE}, {</span><span class="s4">@link </span><span class="s0">#BOOK_RED}, and</span>
 <span class="s0">*  {</span><span class="s4">@link </span><span class="s0">#PRINCETON_ORANGE}.</span>
 <span class="s0">*  For example, {</span><span class="s4">@code </span><span class="s0">StdDraw.setPenColor(StdDraw.MAGENTA)} sets the</span>
 <span class="s0">*  pen color to magenta.</span>
 <span class="s0">*  </span><span class="s5">&lt;p&gt;</span>
 <span class="s0">*  </span><span class="s5">&lt;b&gt;</span><span class="s0">Canvas size.</span><span class="s5">&lt;/b&gt;</span>
 <span class="s0">*  By default, all drawing takes places in a 512-by-512 canvas.</span>
 <span class="s0">*  The canvas does not include the window title or window border.</span>
 <span class="s0">*  You can change the size of the canvas with the following method:</span>
 <span class="s0">*  </span><span class="s5">&lt;ul&gt;</span>
 <span class="s0">*  </span><span class="s5">&lt;li&gt; </span><span class="s0">{</span><span class="s4">@link </span><span class="s0">#setCanvasSize(int width, int height)}</span>
 <span class="s0">*  </span><span class="s5">&lt;/ul&gt;</span>
 <span class="s0">*  </span><span class="s5">&lt;p&gt;</span>
 <span class="s0">*  This sets the canvas size to be </span><span class="s5">&lt;em&gt;</span><span class="s0">width</span><span class="s5">&lt;/em&gt;</span><span class="s0">-by-</span><span class="s5">&lt;em&gt;</span><span class="s0">height</span><span class="s5">&lt;/em&gt; </span><span class="s0">pixels.</span>
 <span class="s0">*  It also erases the current drawing and resets the coordinate system,</span>
 <span class="s0">*  pen radius, pen color, and font back to their default values.</span>
 <span class="s0">*  Ordinarly, this method is called once, at the very beginning of a program.</span>
 <span class="s0">*  For example, {</span><span class="s4">@code </span><span class="s0">StdDraw.setCanvasSize(800, 800)}</span>
 <span class="s0">*  sets the canvas size to be 800-by-800 pixels.</span>
 <span class="s0">*  </span><span class="s5">&lt;p&gt;</span>
 <span class="s0">*  </span><span class="s5">&lt;b&gt;</span><span class="s0">Canvas scale and coordinate system.</span><span class="s5">&lt;/b&gt;</span>
 <span class="s0">*  By default, all drawing takes places in the unit square, with (0, 0) at</span>
 <span class="s0">*  lower left and (1, 1) at upper right. You can change the default</span>
 <span class="s0">*  coordinate system with the following methods:</span>
 <span class="s0">*  </span><span class="s5">&lt;ul&gt;</span>
 <span class="s0">*  </span><span class="s5">&lt;li&gt; </span><span class="s0">{</span><span class="s4">@link </span><span class="s0">#setXscale(double xmin, double xmax)}</span>
 <span class="s0">*  </span><span class="s5">&lt;li&gt; </span><span class="s0">{</span><span class="s4">@link </span><span class="s0">#setYscale(double ymin, double ymax)}</span>
 <span class="s0">*  </span><span class="s5">&lt;li&gt; </span><span class="s0">{</span><span class="s4">@link </span><span class="s0">#setScale(double min, double max)}</span>
 <span class="s0">*  </span><span class="s5">&lt;/ul&gt;</span>
 <span class="s0">*  </span><span class="s5">&lt;p&gt;</span>
 <span class="s0">*  The arguments are the coordinates of the minimum and maximum</span>
 <span class="s0">*  </span><span class="s5">&lt;em&gt;</span><span class="s0">x</span><span class="s5">&lt;/em&gt;</span><span class="s0">- or </span><span class="s5">&lt;em&gt;</span><span class="s0">y</span><span class="s5">&lt;/em&gt;</span><span class="s0">-coordinates that will appear in the canvas.</span>
 <span class="s0">*  For example, if you  wish to use the default coordinate system but</span>
 <span class="s0">*  leave a small margin, you can call {</span><span class="s4">@code </span><span class="s0">StdDraw.setScale(-.05, 1.05)}.</span>
 <span class="s0">*  </span><span class="s5">&lt;p&gt;</span>
 <span class="s0">*  These methods change the coordinate system for subsequent drawing</span>
 <span class="s0">*  commands; they do not affect previous drawings.</span>
 <span class="s0">*  These methods do not change the canvas size; so, if the </span><span class="s5">&lt;em&gt;</span><span class="s0">x</span><span class="s5">&lt;/em&gt;</span><span class="s0">-</span>
 <span class="s0">*  and </span><span class="s5">&lt;em&gt;</span><span class="s0">y</span><span class="s5">&lt;/em&gt;</span><span class="s0">-scales are different, squares will become rectangles</span>
 <span class="s0">*  and circles will become ellipses.</span>
 <span class="s0">*  </span><span class="s5">&lt;p&gt;</span>
 <span class="s0">*  </span><span class="s5">&lt;b&gt;</span><span class="s0">Text.</span><span class="s5">&lt;/b&gt;</span>
 <span class="s0">*  You can use the following methods to annotate your drawings with text:</span>
 <span class="s0">*  </span><span class="s5">&lt;ul&gt;</span>
 <span class="s0">*  </span><span class="s5">&lt;li&gt; </span><span class="s0">{</span><span class="s4">@link </span><span class="s0">#text(double x, double y, String text)}</span>
 <span class="s0">*  </span><span class="s5">&lt;li&gt; </span><span class="s0">{</span><span class="s4">@link </span><span class="s0">#text(double x, double y, String text, double degrees)}</span>
 <span class="s0">*  </span><span class="s5">&lt;li&gt; </span><span class="s0">{</span><span class="s4">@link </span><span class="s0">#textLeft(double x, double y, String text)}</span>
 <span class="s0">*  </span><span class="s5">&lt;li&gt; </span><span class="s0">{</span><span class="s4">@link </span><span class="s0">#textRight(double x, double y, String text)}</span>
 <span class="s0">*  </span><span class="s5">&lt;/ul&gt;</span>
 <span class="s0">*  </span><span class="s5">&lt;p&gt;</span>
 <span class="s0">*  The first two methods write the specified text in the current font,</span>
 <span class="s0">*  centered at (</span><span class="s5">&lt;em&gt;</span><span class="s0">x</span><span class="s5">&lt;/em&gt;</span><span class="s0">, </span><span class="s5">&lt;em&gt;</span><span class="s0">y</span><span class="s5">&lt;/em&gt;</span><span class="s0">).</span>
 <span class="s0">*  The second method allows you to rotate the text.</span>
 <span class="s0">*  The last two methods either left- or right-align the text at (</span><span class="s5">&lt;em&gt;</span><span class="s0">x</span><span class="s5">&lt;/em&gt;</span><span class="s0">, </span><span class="s5">&lt;em&gt;</span><span class="s0">y</span><span class="s5">&lt;/em&gt;</span><span class="s0">).</span>
 <span class="s0">*  </span><span class="s5">&lt;p&gt;</span>
 <span class="s0">*  The default font is a Sans Serif font with point size 16.</span>
 <span class="s0">*  You can use the following method to change the font:</span>
 <span class="s0">*  </span><span class="s5">&lt;ul&gt;</span>
 <span class="s0">*  </span><span class="s5">&lt;li&gt; </span><span class="s0">{</span><span class="s4">@link </span><span class="s0">#setFont(Font font)}</span>
 <span class="s0">*  </span><span class="s5">&lt;/ul&gt;</span>
 <span class="s0">*  </span><span class="s5">&lt;p&gt;</span>
 <span class="s0">*  You use the {</span><span class="s4">@link </span><span class="s0">Font} data type to specify the font. This allows you to</span>
 <span class="s0">*  choose the face, size, and style of the font. For example, the following</span>
 <span class="s0">*  code fragment sets the font to Arial Bold, 60 point.</span>
 <span class="s0">*  </span><span class="s5">&lt;pre&gt;</span>
 <span class="s0">*   Font font = new Font(&quot;Arial&quot;, Font.BOLD, 60);</span>
 <span class="s0">*   StdDraw.setFont(font);</span>
 <span class="s0">*   StdDraw.text(0.5, 0.5, &quot;Hello, World&quot;);</span>
 <span class="s0">*  </span><span class="s5">&lt;/pre&gt;</span>
 <span class="s0">*  </span><span class="s5">&lt;p&gt;</span>
 <span class="s0">*  </span><span class="s5">&lt;b&gt;</span><span class="s0">Images.</span><span class="s5">&lt;/b&gt;</span>
 <span class="s0">*  You can use the following methods to add images to your drawings:</span>
 <span class="s0">*  </span><span class="s5">&lt;ul&gt;</span>
 <span class="s0">*  </span><span class="s5">&lt;li&gt; </span><span class="s0">{</span><span class="s4">@link </span><span class="s0">#picture(double x, double y, String filename)}</span>
 <span class="s0">*  </span><span class="s5">&lt;li&gt; </span><span class="s0">{</span><span class="s4">@link </span><span class="s0">#picture(double x, double y, String filename, double degrees)}</span>
 <span class="s0">*  </span><span class="s5">&lt;li&gt; </span><span class="s0">{</span><span class="s4">@link </span><span class="s0">#picture(double x, double y, String filename, double scaledWidth, double scaledHeight)}</span>
 <span class="s0">*  </span><span class="s5">&lt;li&gt; </span><span class="s0">{</span><span class="s4">@link </span><span class="s0">#picture(double x, double y, String filename, double scaledWidth, double scaledHeight, double degrees)}</span>
 <span class="s0">*  </span><span class="s5">&lt;/ul&gt;</span>
 <span class="s0">*  </span><span class="s5">&lt;p&gt;</span>
 <span class="s0">*  These methods draw the specified image, centered at (</span><span class="s5">&lt;em&gt;</span><span class="s0">x</span><span class="s5">&lt;/em&gt;</span><span class="s0">, </span><span class="s5">&lt;em&gt;</span><span class="s0">y</span><span class="s5">&lt;/em&gt;</span><span class="s0">).</span>
 <span class="s0">*  The supported image formats are JPEG, PNG, and GIF.</span>
 <span class="s0">*  The image will display at its native size, independent of the coordinate system.</span>
 <span class="s0">*  Optionally, you can rotate the image a specified number of degrees counterclockwise</span>
 <span class="s0">*  or rescale it to fit snugly inside a width-by-height bounding box.</span>
 <span class="s0">*  </span><span class="s5">&lt;p&gt;</span>
 <span class="s0">*  </span><span class="s5">&lt;b&gt;</span><span class="s0">Saving to a file.</span><span class="s5">&lt;/b&gt;</span>
 <span class="s0">*  You save your image to a file using the </span><span class="s5">&lt;em&gt;</span><span class="s0">File → Save</span><span class="s5">&lt;/em&gt; </span><span class="s0">menu option.</span>
 <span class="s0">*  You can also save a file programatically using the following method:</span>
 <span class="s0">*  </span><span class="s5">&lt;ul&gt;</span>
 <span class="s0">*  </span><span class="s5">&lt;li&gt; </span><span class="s0">{</span><span class="s4">@link </span><span class="s0">#save(String filename)}</span>
 <span class="s0">*  </span><span class="s5">&lt;/ul&gt;</span>
 <span class="s0">*  </span><span class="s5">&lt;p&gt;</span>
 <span class="s0">*  The supported image formats are JPEG and PNG. The filename must have either the</span>
 <span class="s0">*  extension .jpg or .png.</span>
 <span class="s0">*  We recommend using PNG for drawing that consist solely of geometric shapes and JPEG</span>
 <span class="s0">*  for drawings that contains pictures.</span>
 <span class="s0">*  </span><span class="s5">&lt;p&gt;</span>
 <span class="s0">*  </span><span class="s5">&lt;b&gt;</span><span class="s0">Clearing the canvas.</span><span class="s5">&lt;/b&gt;</span>
 <span class="s0">*  To clear the entire drawing canvas, you can use the following methods:</span>
 <span class="s0">*  </span><span class="s5">&lt;ul&gt;</span>
 <span class="s0">*  </span><span class="s5">&lt;li&gt; </span><span class="s0">{</span><span class="s4">@link </span><span class="s0">#clear()}</span>
 <span class="s0">*  </span><span class="s5">&lt;li&gt; </span><span class="s0">{</span><span class="s4">@link </span><span class="s0">#clear(Color color)}</span>
 <span class="s0">*  </span><span class="s5">&lt;/ul&gt;</span>
 <span class="s0">*  </span><span class="s5">&lt;p&gt;</span>
 <span class="s0">*  The first method clears the canvas to white; the second method</span>
 <span class="s0">*  allows you to specify a color of your choice. For example,</span>
 <span class="s0">*  {</span><span class="s4">@code </span><span class="s0">StdDraw.clear(StdDraw.LIGHT_GRAY)} clears the canvas to a shade</span>
 <span class="s0">*  of gray.</span>
 <span class="s0">*  </span><span class="s5">&lt;p&gt;</span>
 <span class="s0">*  </span><span class="s5">&lt;b&gt;</span><span class="s0">Computer animations and double buffering.</span><span class="s5">&lt;/b&gt;</span>
 <span class="s0">*  Double buffering is one of the most powerful features of standard drawing,</span>
 <span class="s0">*  enabling computer animations.</span>
 <span class="s0">*  The following methods control the way in which objects are drawn:</span>
 <span class="s0">*  </span><span class="s5">&lt;ul&gt;</span>
 <span class="s0">*  </span><span class="s5">&lt;li&gt; </span><span class="s0">{</span><span class="s4">@link </span><span class="s0">#enableDoubleBuffering()}</span>
 <span class="s0">*  </span><span class="s5">&lt;li&gt; </span><span class="s0">{</span><span class="s4">@link </span><span class="s0">#disableDoubleBuffering()}</span>
 <span class="s0">*  </span><span class="s5">&lt;li&gt; </span><span class="s0">{</span><span class="s4">@link </span><span class="s0">#show()}</span>
 <span class="s0">*  </span><span class="s5">&lt;li&gt; </span><span class="s0">{</span><span class="s4">@link </span><span class="s0">#pause(int t)}</span>
 <span class="s0">*  </span><span class="s5">&lt;/ul&gt;</span>
 <span class="s0">*  </span><span class="s5">&lt;p&gt;</span>
 <span class="s0">*  By default, double buffering is disabled, which means that as soon as you</span>
 <span class="s0">*  call a drawing</span>
 <span class="s0">*  method—such as {</span><span class="s4">@code </span><span class="s0">point()} or {</span><span class="s4">@code </span><span class="s0">line()}—the</span>
 <span class="s0">*  results appear on the screen.</span>
 <span class="s0">*  </span><span class="s5">&lt;p&gt;</span>
 <span class="s0">*  When double buffering is enabled by calling {</span><span class="s4">@link </span><span class="s0">#enableDoubleBuffering()},</span>
 <span class="s0">*  all drawing takes place on the </span><span class="s5">&lt;em&gt;</span><span class="s0">offscreen canvas</span><span class="s5">&lt;/em&gt;</span><span class="s0">. The offscreen canvas</span>
 <span class="s0">*  is not displayed. Only when you call</span>
 <span class="s0">*  {</span><span class="s4">@link </span><span class="s0">#show()} does your drawing get copied from the offscreen canvas to</span>
 <span class="s0">*  the onscreen canvas, where it is displayed in the standard drawing window. You</span>
 <span class="s0">*  can think of double buffering as collecting all of the lines, points, shapes,</span>
 <span class="s0">*  and text that you tell it to draw, and then drawing them all</span>
 <span class="s0">*  </span><span class="s5">&lt;em&gt;</span><span class="s0">simultaneously</span><span class="s5">&lt;/em&gt;</span><span class="s0">, upon request.</span>
 <span class="s0">*  </span><span class="s5">&lt;p&gt;</span>
 <span class="s0">*  The most important use of double buffering is to produce computer</span>
 <span class="s0">*  animations, creating the illusion of motion by rapidly</span>
 <span class="s0">*  displaying static drawings. To produce an animation, repeat</span>
 <span class="s0">*  the following four steps:</span>
 <span class="s0">*  </span><span class="s5">&lt;ul&gt;</span>
 <span class="s0">*  </span><span class="s5">&lt;li&gt; </span><span class="s0">Clear the offscreen canvas.</span>
 <span class="s0">*  </span><span class="s5">&lt;li&gt; </span><span class="s0">Draw objects on the offscreen canvas.</span>
 <span class="s0">*  </span><span class="s5">&lt;li&gt; </span><span class="s0">Copy the offscreen canvas to the onscreen canvas.</span>
 <span class="s0">*  </span><span class="s5">&lt;li&gt; </span><span class="s0">Wait for a short while.</span>
 <span class="s0">*  </span><span class="s5">&lt;/ul&gt;</span>
 <span class="s0">*  </span><span class="s5">&lt;p&gt;</span>
 <span class="s0">*  The {</span><span class="s4">@link </span><span class="s0">#clear()}, {</span><span class="s4">@link </span><span class="s0">#show()}, and {</span><span class="s4">@link </span><span class="s0">#pause(int t)} methods</span>
 <span class="s0">*  support the first, third, and fourth of these steps, respectively.</span>
 <span class="s0">*  </span><span class="s5">&lt;p&gt;</span>
 <span class="s0">*  For example, this code fragment animates two balls moving in a circle.</span>
 <span class="s0">*  </span><span class="s5">&lt;pre&gt;</span>
 <span class="s0">*   StdDraw.setScale(-2, +2);</span>
 <span class="s0">*   StdDraw.enableDoubleBuffering();</span>
 <span class="s0">*</span>
 <span class="s0">*   for (double t = 0.0; true; t += 0.02) {</span>
 <span class="s0">*       double x = Math.sin(t);</span>
 <span class="s0">*       double y = Math.cos(t);</span>
 <span class="s0">*       StdDraw.clear();</span>
 <span class="s0">*       StdDraw.filledCircle(x, y, 0.05);</span>
 <span class="s0">*       StdDraw.filledCircle(-x, -y, 0.05);</span>
 <span class="s0">*       StdDraw.show();</span>
 <span class="s0">*       StdDraw.pause(20);</span>
 <span class="s0">*   }</span>
 <span class="s0">*  </span><span class="s5">&lt;/pre&gt;</span>
 <span class="s0">*  </span><span class="s5">&lt;p&gt;</span>
 <span class="s0">*  </span><span class="s5">&lt;b&gt;</span><span class="s0">Keyboard and mouse inputs.</span><span class="s5">&lt;/b&gt;</span>
 <span class="s0">*  Standard drawing has very basic support for keyboard and mouse input.</span>
 <span class="s0">*  It is much less powerful than most user interface libraries provide, but also much simpler.</span>
 <span class="s0">*  You can use the following methods to intercept mouse events:</span>
 <span class="s0">*  </span><span class="s5">&lt;ul&gt;</span>
 <span class="s0">*  </span><span class="s5">&lt;li&gt; </span><span class="s0">{</span><span class="s4">@link </span><span class="s0">#isMousePressed()}</span>
 <span class="s0">*  </span><span class="s5">&lt;li&gt; </span><span class="s0">{</span><span class="s4">@link </span><span class="s0">#mouseX()}</span>
 <span class="s0">*  </span><span class="s5">&lt;li&gt; </span><span class="s0">{</span><span class="s4">@link </span><span class="s0">#mouseY()}</span>
 <span class="s0">*  </span><span class="s5">&lt;/ul&gt;</span>
 <span class="s0">*  </span><span class="s5">&lt;p&gt;</span>
 <span class="s0">*  The first method tells you whether a mouse button is currently being pressed.</span>
 <span class="s0">*  The last two methods tells you the </span><span class="s5">&lt;em&gt;</span><span class="s0">x</span><span class="s5">&lt;/em&gt;</span><span class="s0">- and </span><span class="s5">&lt;em&gt;</span><span class="s0">y</span><span class="s5">&lt;/em&gt;</span><span class="s0">-coordinates of the mouse's</span>
 <span class="s0">*  current position, using the same coordinate system as the canvas (the unit square, by default).</span>
 <span class="s0">*  You should use these methods in an animation loop that waits a short while before trying</span>
 <span class="s0">*  to poll the mouse for its current state.</span>
 <span class="s0">*  You can use the following methods to intercept keyboard events:</span>
 <span class="s0">*  </span><span class="s5">&lt;ul&gt;</span>
 <span class="s0">*  </span><span class="s5">&lt;li&gt; </span><span class="s0">{</span><span class="s4">@link </span><span class="s0">#hasNextKeyTyped()}</span>
 <span class="s0">*  </span><span class="s5">&lt;li&gt; </span><span class="s0">{</span><span class="s4">@link </span><span class="s0">#nextKeyTyped()}</span>
 <span class="s0">*  </span><span class="s5">&lt;li&gt; </span><span class="s0">{</span><span class="s4">@link </span><span class="s0">#isKeyPressed(int keycode)}</span>
 <span class="s0">*  </span><span class="s5">&lt;/ul&gt;</span>
 <span class="s0">*  </span><span class="s5">&lt;p&gt;</span>
 <span class="s0">*  If the user types lots of keys, they will be saved in a list until you process them.</span>
 <span class="s0">*  The first method tells you whether the user has typed a key (that your program has</span>
 <span class="s0">*  not yet processed).</span>
 <span class="s0">*  The second method returns the next key that the user typed (that your program has</span>
 <span class="s0">*  not yet processed) and removes it from the list of saved keystrokes.</span>
 <span class="s0">*  The third method tells you whether a key is currently being pressed.</span>
 <span class="s0">*  </span><span class="s5">&lt;p&gt;</span>
 <span class="s0">*  </span><span class="s5">&lt;b&gt;</span><span class="s0">Accessing control parameters.</span><span class="s5">&lt;/b&gt;</span>
 <span class="s0">*  You can use the following methods to access the current pen color, pen radius,</span>
 <span class="s0">*  and font:</span>
 <span class="s0">*  </span><span class="s5">&lt;ul&gt;</span>
 <span class="s0">*  </span><span class="s5">&lt;li&gt; </span><span class="s0">{</span><span class="s4">@link </span><span class="s0">#getPenColor()}</span>
 <span class="s0">*  </span><span class="s5">&lt;li&gt; </span><span class="s0">{</span><span class="s4">@link </span><span class="s0">#getPenRadius()}</span>
 <span class="s0">*  </span><span class="s5">&lt;li&gt; </span><span class="s0">{</span><span class="s4">@link </span><span class="s0">#getFont()}</span>
 <span class="s0">*  </span><span class="s5">&lt;/ul&gt;</span>
 <span class="s0">*  </span><span class="s5">&lt;p&gt;</span>
 <span class="s0">*  These methods are useful when you want to temporarily change a</span>
 <span class="s0">*  control parameter and reset it back to its original value.</span>
 <span class="s0">*  </span><span class="s5">&lt;p&gt;</span>
 <span class="s0">*  </span><span class="s5">&lt;b&gt;</span><span class="s0">Corner cases.</span><span class="s5">&lt;/b&gt;</span>
 <span class="s0">*  Here are some corner cases.</span>
 <span class="s0">*  </span><span class="s5">&lt;ul&gt;</span>
 <span class="s0">*  </span><span class="s5">&lt;li&gt; </span><span class="s0">Drawing an object outside (or partly outside) the canvas is permitted.</span>
 <span class="s0">*       However, only the part of the object that appears inside the canvas</span>
 <span class="s0">*       will be visible.</span>
 <span class="s0">*  </span><span class="s5">&lt;li&gt; </span><span class="s0">Any method that is passed a {</span><span class="s4">@code </span><span class="s0">null} argument will throw an</span>
 <span class="s0">*       {</span><span class="s4">@link </span><span class="s0">IllegalArgumentException}.</span>
 <span class="s0">*  </span><span class="s5">&lt;li&gt; </span><span class="s0">Any method that is passed a {</span><span class="s4">@link </span><span class="s0">Double#NaN},</span>
 <span class="s0">*       {</span><span class="s4">@link </span><span class="s0">Double#POSITIVE_INFINITY}, or {</span><span class="s4">@link </span><span class="s0">Double#NEGATIVE_INFINITY}</span>
 <span class="s0">*       argument will throw an {</span><span class="s4">@link </span><span class="s0">IllegalArgumentException}.</span>
 <span class="s0">*  </span><span class="s5">&lt;li&gt; </span><span class="s0">Due to floating-point issues, an object drawn with an </span><span class="s5">&lt;em&gt;</span><span class="s0">x</span><span class="s5">&lt;/em&gt;</span><span class="s0">- or</span>
 <span class="s0">*       </span><span class="s5">&lt;em&gt;</span><span class="s0">y</span><span class="s5">&lt;/em&gt;</span><span class="s0">-coordinate that is way outside the canvas (such as the line segment</span>
 <span class="s0">*       from (0.5, –10^308) to (0.5, 10^308) may not be visible even in the</span>
 <span class="s0">*       part of the canvas where it should be.</span>
 <span class="s0">*  </span><span class="s5">&lt;/ul&gt;</span>
 <span class="s0">*  </span><span class="s5">&lt;p&gt;</span>
 <span class="s0">*  </span><span class="s5">&lt;b&gt;</span><span class="s0">Performance tricks.</span><span class="s5">&lt;/b&gt;</span>
 <span class="s0">*  Standard drawing is capable of drawing large amounts of data.</span>
 <span class="s0">*  Here are a few tricks and tips:</span>
 <span class="s0">*  </span><span class="s5">&lt;ul&gt;</span>
 <span class="s0">*  </span><span class="s5">&lt;li&gt; </span><span class="s0">Use </span><span class="s5">&lt;em&gt;</span><span class="s0">double buffering</span><span class="s5">&lt;/em&gt; </span><span class="s0">for static drawing with a large</span>
 <span class="s0">*       number of objects.</span>
 <span class="s0">*       That is, call {</span><span class="s4">@link </span><span class="s0">#enableDoubleBuffering()} before</span>
 <span class="s0">*       the sequence of drawing commands and call {</span><span class="s4">@link </span><span class="s0">#show()} afterwards.</span>
 <span class="s0">*       Incrementally displaying a complex drawing while it is being</span>
 <span class="s0">*       created can be intolerably inefficient on many computer systems.</span>
 <span class="s0">*  </span><span class="s5">&lt;li&gt; </span><span class="s0">When drawing computer animations, call {</span><span class="s4">@code </span><span class="s0">show()}</span>
 <span class="s0">*       only once per frame, not after drawing each individual object.</span>
 <span class="s0">*  </span><span class="s5">&lt;li&gt; </span><span class="s0">If you call {</span><span class="s4">@code </span><span class="s0">picture()} multiple times with the same filename,</span>
 <span class="s0">*       Java will cache the image, so you do not incur the cost of reading</span>
 <span class="s0">*       from a file each time.</span>
 <span class="s0">*  </span><span class="s5">&lt;/ul&gt;</span>
 <span class="s0">*  </span><span class="s5">&lt;p&gt;</span>
 <span class="s0">*  </span><span class="s5">&lt;b&gt;</span><span class="s0">Known bugs and issues.</span><span class="s5">&lt;/b&gt;</span>
 <span class="s0">*  </span><span class="s5">&lt;ul&gt;</span>
 <span class="s0">*  </span><span class="s5">&lt;li&gt; </span><span class="s0">The {</span><span class="s4">@code </span><span class="s0">picture()} methods may not draw the portion of the image that is</span>
 <span class="s0">*       inside the canvas if the center point (</span><span class="s5">&lt;em&gt;</span><span class="s0">x</span><span class="s5">&lt;/em&gt;</span><span class="s0">, </span><span class="s5">&lt;em&gt;</span><span class="s0">y</span><span class="s5">&lt;/em&gt;</span><span class="s0">) is outside the</span>
 <span class="s0">*       canvas.</span>
 <span class="s0">*       This bug appears only on some systems.</span>
 <span class="s0">*  </span><span class="s5">&lt;/ul&gt;</span>
 <span class="s0">*  </span><span class="s5">&lt;p&gt;</span>
 <span class="s0">*  </span><span class="s5">&lt;b&gt;</span><span class="s0">Reference.</span><span class="s5">&lt;/b&gt;</span>
 <span class="s0">*  For additional documentation,</span>
 <span class="s0">*  see </span><span class="s5">&lt;a href=&quot;https://introcs.cs.princeton.edu/15inout&quot;&gt;</span><span class="s0">Section 1.5</span><span class="s5">&lt;/a&gt; </span><span class="s0">of</span>
 <span class="s0">*  </span><span class="s5">&lt;em&gt;</span><span class="s0">Computer Science: An Interdisciplinary Approach</span><span class="s5">&lt;/em&gt;</span>
 <span class="s0">*  by Robert Sedgewick and Kevin Wayne.</span>
 <span class="s0">*</span>
 <span class="s0">*  </span><span class="s4">@author </span><span class="s0">Robert Sedgewick</span>
 <span class="s0">*  </span><span class="s4">@author </span><span class="s0">Kevin Wayne</span>
 <span class="s0">*/</span>
<span class="s2">public final class </span><span class="s1">StdDraw </span><span class="s2">implements </span><span class="s1">ActionListener</span><span class="s3">, </span><span class="s1">MouseListener</span><span class="s3">, </span><span class="s1">MouseMotionListener</span><span class="s3">, </span><span class="s1">KeyListener </span><span class="s3">{</span>

    <span class="s0">/**</span>
     <span class="s0">*  The color black.</span>
     <span class="s0">*/</span>
    <span class="s2">public static final </span><span class="s1">Color BLACK </span><span class="s3">= </span><span class="s1">Color</span><span class="s3">.</span><span class="s1">BLACK</span><span class="s3">;</span>

    <span class="s0">/**</span>
     <span class="s0">*  The color blue.</span>
     <span class="s0">*/</span>
    <span class="s2">public static final </span><span class="s1">Color BLUE </span><span class="s3">= </span><span class="s1">Color</span><span class="s3">.</span><span class="s1">BLUE</span><span class="s3">;</span>

    <span class="s0">/**</span>
     <span class="s0">*  The color cyan.</span>
     <span class="s0">*/</span>
    <span class="s2">public static final </span><span class="s1">Color CYAN </span><span class="s3">= </span><span class="s1">Color</span><span class="s3">.</span><span class="s1">CYAN</span><span class="s3">;</span>

    <span class="s0">/**</span>
     <span class="s0">*  The color dark gray.</span>
     <span class="s0">*/</span>
    <span class="s2">public static final </span><span class="s1">Color DARK_GRAY </span><span class="s3">= </span><span class="s1">Color</span><span class="s3">.</span><span class="s1">DARK_GRAY</span><span class="s3">;</span>

    <span class="s0">/**</span>
     <span class="s0">*  The color gray.</span>
     <span class="s0">*/</span>
    <span class="s2">public static final </span><span class="s1">Color GRAY </span><span class="s3">= </span><span class="s1">Color</span><span class="s3">.</span><span class="s1">GRAY</span><span class="s3">;</span>

    <span class="s0">/**</span>
     <span class="s0">*  The color green.</span>
     <span class="s0">*/</span>
    <span class="s2">public static final </span><span class="s1">Color GREEN  </span><span class="s3">= </span><span class="s1">Color</span><span class="s3">.</span><span class="s1">GREEN</span><span class="s3">;</span>

    <span class="s0">/**</span>
     <span class="s0">*  The color light gray.</span>
     <span class="s0">*/</span>
    <span class="s2">public static final </span><span class="s1">Color LIGHT_GRAY </span><span class="s3">= </span><span class="s1">Color</span><span class="s3">.</span><span class="s1">LIGHT_GRAY</span><span class="s3">;</span>

    <span class="s0">/**</span>
     <span class="s0">*  The color magenta.</span>
     <span class="s0">*/</span>
    <span class="s2">public static final </span><span class="s1">Color MAGENTA </span><span class="s3">= </span><span class="s1">Color</span><span class="s3">.</span><span class="s1">MAGENTA</span><span class="s3">;</span>

    <span class="s0">/**</span>
     <span class="s0">*  The color orange.</span>
     <span class="s0">*/</span>
    <span class="s2">public static final </span><span class="s1">Color ORANGE </span><span class="s3">= </span><span class="s1">Color</span><span class="s3">.</span><span class="s1">ORANGE</span><span class="s3">;</span>

    <span class="s0">/**</span>
     <span class="s0">*  The color pink.</span>
     <span class="s0">*/</span>
    <span class="s2">public static final </span><span class="s1">Color PINK </span><span class="s3">= </span><span class="s1">Color</span><span class="s3">.</span><span class="s1">PINK</span><span class="s3">;</span>

    <span class="s0">/**</span>
     <span class="s0">*  The color red.</span>
     <span class="s0">*/</span>
    <span class="s2">public static final </span><span class="s1">Color RED </span><span class="s3">= </span><span class="s1">Color</span><span class="s3">.</span><span class="s1">RED</span><span class="s3">;</span>

    <span class="s0">/**</span>
     <span class="s0">*  The color white.</span>
     <span class="s0">*/</span>
    <span class="s2">public static final </span><span class="s1">Color WHITE </span><span class="s3">= </span><span class="s1">Color</span><span class="s3">.</span><span class="s1">WHITE</span><span class="s3">;</span>

    <span class="s0">/**</span>
     <span class="s0">*  The color yellow.</span>
     <span class="s0">*/</span>
    <span class="s2">public static final </span><span class="s1">Color YELLOW </span><span class="s3">= </span><span class="s1">Color</span><span class="s3">.</span><span class="s1">YELLOW</span><span class="s3">;</span>

    <span class="s0">/**</span>
     <span class="s0">* Shade of blue used in </span><span class="s5">&lt;em&gt;</span><span class="s0">Introduction to Programming in Java</span><span class="s5">&lt;/em&gt;</span><span class="s0">.</span>
     <span class="s0">* It is Pantone 300U. The RGB values are approximately (9, 90, 166).</span>
     <span class="s0">*/</span>
    <span class="s2">public static final </span><span class="s1">Color BOOK_BLUE </span><span class="s3">= </span><span class="s2">new </span><span class="s1">Color</span><span class="s3">(</span><span class="s6">9</span><span class="s3">, </span><span class="s6">90</span><span class="s3">, </span><span class="s6">166</span><span class="s3">);</span>

    <span class="s0">/**</span>
     <span class="s0">* Shade of light blue used in </span><span class="s5">&lt;em&gt;</span><span class="s0">Introduction to Programming in Java</span><span class="s5">&lt;/em&gt;</span><span class="s0">.</span>
     <span class="s0">* The RGB values are approximately (103, 198, 243).</span>
     <span class="s0">*/</span>
    <span class="s2">public static final </span><span class="s1">Color BOOK_LIGHT_BLUE </span><span class="s3">= </span><span class="s2">new </span><span class="s1">Color</span><span class="s3">(</span><span class="s6">103</span><span class="s3">, </span><span class="s6">198</span><span class="s3">, </span><span class="s6">243</span><span class="s3">);</span>

    <span class="s0">/**</span>
     <span class="s0">* Shade of red used in </span><span class="s5">&lt;em&gt;</span><span class="s0">Algorithms, 4th edition</span><span class="s5">&lt;/em&gt;</span><span class="s0">.</span>
     <span class="s0">* It is Pantone 1805U. The RGB values are approximately (150, 35, 31).</span>
     <span class="s0">*/</span>
    <span class="s2">public static final </span><span class="s1">Color BOOK_RED </span><span class="s3">= </span><span class="s2">new </span><span class="s1">Color</span><span class="s3">(</span><span class="s6">150</span><span class="s3">, </span><span class="s6">35</span><span class="s3">, </span><span class="s6">31</span><span class="s3">);</span>

    <span class="s0">/**</span>
     <span class="s0">* Shade of orange used in Princeton University's identity.</span>
     <span class="s0">* It is PMS 158. The RGB values are approximately (245, 128, 37).</span>
     <span class="s0">*/</span>
    <span class="s2">public static final </span><span class="s1">Color PRINCETON_ORANGE </span><span class="s3">= </span><span class="s2">new </span><span class="s1">Color</span><span class="s3">(</span><span class="s6">245</span><span class="s3">, </span><span class="s6">128</span><span class="s3">, </span><span class="s6">37</span><span class="s3">);</span>

    <span class="s7">// default colors</span>
    <span class="s2">private static final </span><span class="s1">Color DEFAULT_PEN_COLOR   </span><span class="s3">= </span><span class="s1">BLACK</span><span class="s3">;</span>
    <span class="s2">private static final </span><span class="s1">Color DEFAULT_CLEAR_COLOR </span><span class="s3">= </span><span class="s1">WHITE</span><span class="s3">;</span>

    <span class="s7">// current pen color</span>
    <span class="s2">private static </span><span class="s1">Color penColor</span><span class="s3">;</span>

    <span class="s7">// default canvas size is DEFAULT_SIZE-by-DEFAULT_SIZE</span>
    <span class="s2">private static final int </span><span class="s1">DEFAULT_SIZE </span><span class="s3">= </span><span class="s6">512</span><span class="s3">;</span>
    <span class="s2">private static int </span><span class="s1">width  </span><span class="s3">= </span><span class="s1">DEFAULT_SIZE</span><span class="s3">;</span>
    <span class="s2">private static int </span><span class="s1">height </span><span class="s3">= </span><span class="s1">DEFAULT_SIZE</span><span class="s3">;</span>

    <span class="s7">// default pen radius</span>
    <span class="s2">private static final double </span><span class="s1">DEFAULT_PEN_RADIUS </span><span class="s3">= </span><span class="s6">0.002</span><span class="s3">;</span>

    <span class="s7">// current pen radius</span>
    <span class="s2">private static double </span><span class="s1">penRadius</span><span class="s3">;</span>

    <span class="s7">// show we draw immediately or wait until next show?</span>
    <span class="s2">private static boolean </span><span class="s1">defer </span><span class="s3">= </span><span class="s2">false</span><span class="s3">;</span>

    <span class="s7">// boundary of drawing canvas, 0% border</span>
    <span class="s7">// private static final double BORDER = 0.05;</span>
    <span class="s2">private static final double </span><span class="s1">BORDER </span><span class="s3">= </span><span class="s6">0.00</span><span class="s3">;</span>
    <span class="s2">private static final double </span><span class="s1">DEFAULT_XMIN </span><span class="s3">= </span><span class="s6">0.0</span><span class="s3">;</span>
    <span class="s2">private static final double </span><span class="s1">DEFAULT_XMAX </span><span class="s3">= </span><span class="s6">1.0</span><span class="s3">;</span>
    <span class="s2">private static final double </span><span class="s1">DEFAULT_YMIN </span><span class="s3">= </span><span class="s6">0.0</span><span class="s3">;</span>
    <span class="s2">private static final double </span><span class="s1">DEFAULT_YMAX </span><span class="s3">= </span><span class="s6">1.0</span><span class="s3">;</span>
    <span class="s2">private static double </span><span class="s1">xmin</span><span class="s3">, </span><span class="s1">ymin</span><span class="s3">, </span><span class="s1">xmax</span><span class="s3">, </span><span class="s1">ymax</span><span class="s3">;</span>

    <span class="s7">// for synchronization</span>
    <span class="s2">private static </span><span class="s1">Object mouseLock </span><span class="s3">= </span><span class="s2">new </span><span class="s1">Object</span><span class="s3">();</span>
    <span class="s2">private static </span><span class="s1">Object keyLock </span><span class="s3">= </span><span class="s2">new </span><span class="s1">Object</span><span class="s3">();</span>

    <span class="s7">// default font</span>
    <span class="s2">private static final </span><span class="s1">Font DEFAULT_FONT </span><span class="s3">= </span><span class="s2">new </span><span class="s1">Font</span><span class="s3">(</span><span class="s8">&quot;SansSerif&quot;</span><span class="s3">, </span><span class="s1">Font</span><span class="s3">.</span><span class="s1">PLAIN</span><span class="s3">, </span><span class="s6">16</span><span class="s3">);</span>

    <span class="s7">// current font</span>
    <span class="s2">private static </span><span class="s1">Font font</span><span class="s3">;</span>

    <span class="s7">// double buffered graphics</span>
    <span class="s2">private static </span><span class="s1">BufferedImage offscreenImage</span><span class="s3">, </span><span class="s1">onscreenImage</span><span class="s3">;</span>
    <span class="s2">private static </span><span class="s1">Graphics2D offscreen</span><span class="s3">, </span><span class="s1">onscreen</span><span class="s3">;</span>

    <span class="s7">// singleton for callbacks: avoids generation of extra .class files</span>
    <span class="s2">private static </span><span class="s1">StdDraw std </span><span class="s3">= </span><span class="s2">new </span><span class="s1">StdDraw</span><span class="s3">();</span>

    <span class="s7">// the frame for drawing to the screen</span>
    <span class="s2">private static </span><span class="s1">JFrame frame</span><span class="s3">;</span>

    <span class="s7">// mouse state</span>
    <span class="s2">private static boolean </span><span class="s1">isMousePressed </span><span class="s3">= </span><span class="s2">false</span><span class="s3">;</span>
    <span class="s2">private static double </span><span class="s1">mouseX </span><span class="s3">= </span><span class="s6">0</span><span class="s3">;</span>
    <span class="s2">private static double </span><span class="s1">mouseY </span><span class="s3">= </span><span class="s6">0</span><span class="s3">;</span>

    <span class="s7">// queue of typed key characters</span>
    <span class="s2">private static </span><span class="s1">LinkedList</span><span class="s3">&lt;</span><span class="s1">Character</span><span class="s3">&gt; </span><span class="s1">keysTyped </span><span class="s3">= </span><span class="s2">new </span><span class="s1">LinkedList</span><span class="s3">&lt;</span><span class="s1">Character</span><span class="s3">&gt;();</span>

    <span class="s7">// set of key codes currently pressed down</span>
    <span class="s2">private static </span><span class="s1">TreeSet</span><span class="s3">&lt;</span><span class="s1">Integer</span><span class="s3">&gt; </span><span class="s1">keysDown </span><span class="s3">= </span><span class="s2">new </span><span class="s1">TreeSet</span><span class="s3">&lt;</span><span class="s1">Integer</span><span class="s3">&gt;();</span>

    <span class="s7">// singleton pattern: client can't instantiate</span>
    <span class="s2">private </span><span class="s1">StdDraw</span><span class="s3">() { }</span>


    <span class="s7">// static initializer</span>
    <span class="s2">static </span><span class="s3">{</span>
        <span class="s1">init</span><span class="s3">();</span>
    <span class="s3">}</span>

    <span class="s0">/**</span>
     <span class="s0">* Sets the canvas (drawing area) to be 512-by-512 pixels.</span>
     <span class="s0">* This also erases the current drawing and resets the coordinate system,</span>
     <span class="s0">* pen radius, pen color, and font back to their default values.</span>
     <span class="s0">* Ordinarly, this method is called once, at the very beginning</span>
     <span class="s0">* of a program.</span>
     <span class="s0">*/</span>
    <span class="s2">public static void </span><span class="s1">setCanvasSize</span><span class="s3">() {</span>
        <span class="s1">setCanvasSize</span><span class="s3">(</span><span class="s1">DEFAULT_SIZE</span><span class="s3">, </span><span class="s1">DEFAULT_SIZE</span><span class="s3">);</span>
    <span class="s3">}</span>

    <span class="s0">/**</span>
     <span class="s0">* Sets the canvas (drawing area) to be </span><span class="s5">&lt;em&gt;</span><span class="s0">width</span><span class="s5">&lt;/em&gt;</span><span class="s0">-by-</span><span class="s5">&lt;em&gt;</span><span class="s0">height</span><span class="s5">&lt;/em&gt; </span><span class="s0">pixels.</span>
     <span class="s0">* This also erases the current drawing and resets the coordinate system,</span>
     <span class="s0">* pen radius, pen color, and font back to their default values.</span>
     <span class="s0">* Ordinarly, this method is called once, at the very beginning</span>
     <span class="s0">* of a program.</span>
     <span class="s0">*</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">canvasWidth the width as a number of pixels</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">canvasHeight the height as a number of pixels</span>
     <span class="s0">* </span><span class="s4">@throws </span><span class="s0">IllegalArgumentException unless both {</span><span class="s4">@code </span><span class="s0">canvasWidth} and</span>
     <span class="s0">*         {</span><span class="s4">@code </span><span class="s0">canvasHeight} are positive</span>
     <span class="s0">*/</span>
    <span class="s2">public static void </span><span class="s1">setCanvasSize</span><span class="s3">(</span><span class="s2">int </span><span class="s1">canvasWidth</span><span class="s3">, </span><span class="s2">int </span><span class="s1">canvasHeight</span><span class="s3">) {</span>
        <span class="s2">if </span><span class="s3">(</span><span class="s1">canvasWidth </span><span class="s3">&lt;= </span><span class="s6">0</span><span class="s3">) </span><span class="s2">throw new </span><span class="s1">IllegalArgumentException</span><span class="s3">(</span><span class="s8">&quot;width must be positive&quot;</span><span class="s3">);</span>
        <span class="s2">if </span><span class="s3">(</span><span class="s1">canvasHeight </span><span class="s3">&lt;= </span><span class="s6">0</span><span class="s3">) </span><span class="s2">throw new </span><span class="s1">IllegalArgumentException</span><span class="s3">(</span><span class="s8">&quot;height must be positive&quot;</span><span class="s3">);</span>
        <span class="s1">width </span><span class="s3">= </span><span class="s1">canvasWidth</span><span class="s3">;</span>
        <span class="s1">height </span><span class="s3">= </span><span class="s1">canvasHeight</span><span class="s3">;</span>
        <span class="s1">init</span><span class="s3">();</span>
    <span class="s3">}</span>

    <span class="s7">// init</span>
    <span class="s2">private static void </span><span class="s1">init</span><span class="s3">() {</span>
        <span class="s2">if </span><span class="s3">(</span><span class="s1">frame </span><span class="s3">!= </span><span class="s2">null</span><span class="s3">) </span><span class="s1">frame</span><span class="s3">.</span><span class="s1">setVisible</span><span class="s3">(</span><span class="s2">false</span><span class="s3">);</span>
        <span class="s1">frame </span><span class="s3">= </span><span class="s2">new </span><span class="s1">JFrame</span><span class="s3">();</span>
        <span class="s1">offscreenImage </span><span class="s3">= </span><span class="s2">new </span><span class="s1">BufferedImage</span><span class="s3">(</span><span class="s6">2</span><span class="s3">*</span><span class="s1">width</span><span class="s3">, </span><span class="s6">2</span><span class="s3">*</span><span class="s1">height</span><span class="s3">, </span><span class="s1">BufferedImage</span><span class="s3">.</span><span class="s1">TYPE_INT_ARGB</span><span class="s3">);</span>
        <span class="s1">onscreenImage  </span><span class="s3">= </span><span class="s2">new </span><span class="s1">BufferedImage</span><span class="s3">(</span><span class="s6">2</span><span class="s3">*</span><span class="s1">width</span><span class="s3">, </span><span class="s6">2</span><span class="s3">*</span><span class="s1">height</span><span class="s3">, </span><span class="s1">BufferedImage</span><span class="s3">.</span><span class="s1">TYPE_INT_ARGB</span><span class="s3">);</span>
        <span class="s1">offscreen </span><span class="s3">= </span><span class="s1">offscreenImage</span><span class="s3">.</span><span class="s1">createGraphics</span><span class="s3">();</span>
        <span class="s1">onscreen  </span><span class="s3">= </span><span class="s1">onscreenImage</span><span class="s3">.</span><span class="s1">createGraphics</span><span class="s3">();</span>
        <span class="s1">offscreen</span><span class="s3">.</span><span class="s1">scale</span><span class="s3">(</span><span class="s6">2.0</span><span class="s3">, </span><span class="s6">2.0</span><span class="s3">);  </span><span class="s7">// since we made it 2x as big</span>

        <span class="s1">setXscale</span><span class="s3">();</span>
        <span class="s1">setYscale</span><span class="s3">();</span>
        <span class="s1">offscreen</span><span class="s3">.</span><span class="s1">setColor</span><span class="s3">(</span><span class="s1">DEFAULT_CLEAR_COLOR</span><span class="s3">);</span>
        <span class="s1">offscreen</span><span class="s3">.</span><span class="s1">fillRect</span><span class="s3">(</span><span class="s6">0</span><span class="s3">, </span><span class="s6">0</span><span class="s3">, </span><span class="s1">width</span><span class="s3">, </span><span class="s1">height</span><span class="s3">);</span>
        <span class="s1">setPenColor</span><span class="s3">();</span>
        <span class="s1">setPenRadius</span><span class="s3">();</span>
        <span class="s1">setFont</span><span class="s3">();</span>
        <span class="s1">clear</span><span class="s3">();</span>

        <span class="s7">// add antialiasing</span>
        <span class="s1">RenderingHints hints </span><span class="s3">= </span><span class="s2">new </span><span class="s1">RenderingHints</span><span class="s3">(</span><span class="s1">RenderingHints</span><span class="s3">.</span><span class="s1">KEY_ANTIALIASING</span><span class="s3">,</span>
                <span class="s1">RenderingHints</span><span class="s3">.</span><span class="s1">VALUE_ANTIALIAS_ON</span><span class="s3">);</span>
        <span class="s1">hints</span><span class="s3">.</span><span class="s1">put</span><span class="s3">(</span><span class="s1">RenderingHints</span><span class="s3">.</span><span class="s1">KEY_RENDERING</span><span class="s3">, </span><span class="s1">RenderingHints</span><span class="s3">.</span><span class="s1">VALUE_RENDER_QUALITY</span><span class="s3">);</span>
        <span class="s1">offscreen</span><span class="s3">.</span><span class="s1">addRenderingHints</span><span class="s3">(</span><span class="s1">hints</span><span class="s3">);</span>

        <span class="s7">// frame stuff</span>
        <span class="s1">RetinaImageIcon icon </span><span class="s3">= </span><span class="s2">new </span><span class="s1">RetinaImageIcon</span><span class="s3">(</span><span class="s1">onscreenImage</span><span class="s3">);</span>
        <span class="s1">JLabel draw </span><span class="s3">= </span><span class="s2">new </span><span class="s1">JLabel</span><span class="s3">(</span><span class="s1">icon</span><span class="s3">);</span>

        <span class="s1">draw</span><span class="s3">.</span><span class="s1">addMouseListener</span><span class="s3">(</span><span class="s1">std</span><span class="s3">);</span>
        <span class="s1">draw</span><span class="s3">.</span><span class="s1">addMouseMotionListener</span><span class="s3">(</span><span class="s1">std</span><span class="s3">);</span>

        <span class="s1">frame</span><span class="s3">.</span><span class="s1">setContentPane</span><span class="s3">(</span><span class="s1">draw</span><span class="s3">);</span>
        <span class="s1">frame</span><span class="s3">.</span><span class="s1">addKeyListener</span><span class="s3">(</span><span class="s1">std</span><span class="s3">);    </span><span class="s7">// JLabel cannot get keyboard focus</span>
        <span class="s1">frame</span><span class="s3">.</span><span class="s1">setFocusTraversalKeysEnabled</span><span class="s3">(</span><span class="s2">false</span><span class="s3">);  </span><span class="s7">// allow VK_TAB with isKeyPressed()</span>
        <span class="s1">frame</span><span class="s3">.</span><span class="s1">setResizable</span><span class="s3">(</span><span class="s2">false</span><span class="s3">);</span>
        <span class="s1">frame</span><span class="s3">.</span><span class="s1">setDefaultCloseOperation</span><span class="s3">(</span><span class="s1">JFrame</span><span class="s3">.</span><span class="s1">EXIT_ON_CLOSE</span><span class="s3">);            </span><span class="s7">// closes all windows</span>
        <span class="s7">// frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);      // closes only current window</span>
        <span class="s1">frame</span><span class="s3">.</span><span class="s1">setTitle</span><span class="s3">(</span><span class="s8">&quot;Standard Draw&quot;</span><span class="s3">);</span>
        <span class="s1">frame</span><span class="s3">.</span><span class="s1">setJMenuBar</span><span class="s3">(</span><span class="s1">createMenuBar</span><span class="s3">());</span>
        <span class="s1">frame</span><span class="s3">.</span><span class="s1">pack</span><span class="s3">();</span>
        <span class="s1">frame</span><span class="s3">.</span><span class="s1">requestFocusInWindow</span><span class="s3">();</span>
        <span class="s1">frame</span><span class="s3">.</span><span class="s1">setVisible</span><span class="s3">(</span><span class="s2">true</span><span class="s3">);</span>
    <span class="s3">}</span>

    <span class="s7">// create the menu bar (changed to private)</span>
    <span class="s2">private static </span><span class="s1">JMenuBar createMenuBar</span><span class="s3">() {</span>
        <span class="s1">JMenuBar menuBar </span><span class="s3">= </span><span class="s2">new </span><span class="s1">JMenuBar</span><span class="s3">();</span>
        <span class="s1">JMenu menu </span><span class="s3">= </span><span class="s2">new </span><span class="s1">JMenu</span><span class="s3">(</span><span class="s8">&quot;File&quot;</span><span class="s3">);</span>
        <span class="s1">menuBar</span><span class="s3">.</span><span class="s1">add</span><span class="s3">(</span><span class="s1">menu</span><span class="s3">);</span>
        <span class="s1">JMenuItem menuItem1 </span><span class="s3">= </span><span class="s2">new </span><span class="s1">JMenuItem</span><span class="s3">(</span><span class="s8">&quot; Save...   &quot;</span><span class="s3">);</span>
        <span class="s1">menuItem1</span><span class="s3">.</span><span class="s1">addActionListener</span><span class="s3">(</span><span class="s1">std</span><span class="s3">);</span>
        <span class="s7">// Java 10+: replace getMenuShortcutKeyMask() with getMenuShortcutKeyMaskEx()</span>
        <span class="s1">menuItem1</span><span class="s3">.</span><span class="s1">setAccelerator</span><span class="s3">(</span><span class="s1">KeyStroke</span><span class="s3">.</span><span class="s1">getKeyStroke</span><span class="s3">(</span><span class="s1">KeyEvent</span><span class="s3">.</span><span class="s1">VK_S</span><span class="s3">,</span>
                <span class="s1">Toolkit</span><span class="s3">.</span><span class="s1">getDefaultToolkit</span><span class="s3">().</span><span class="s1">getMenuShortcutKeyMask</span><span class="s3">()));</span>
        <span class="s1">menu</span><span class="s3">.</span><span class="s1">add</span><span class="s3">(</span><span class="s1">menuItem1</span><span class="s3">);</span>
        <span class="s2">return </span><span class="s1">menuBar</span><span class="s3">;</span>
    <span class="s3">}</span>

    <span class="s0">/***************************************************************************</span>
     <span class="s0">*  User and screen coordinate systems.</span>
     <span class="s0">***************************************************************************/</span>

    <span class="s7">// throw an IllegalArgumentException if x is NaN or infinite</span>
    <span class="s2">private static void </span><span class="s1">validate</span><span class="s3">(</span><span class="s2">double </span><span class="s1">x</span><span class="s3">, </span><span class="s1">String name</span><span class="s3">) {</span>
        <span class="s2">if </span><span class="s3">(</span><span class="s1">Double</span><span class="s3">.</span><span class="s1">isNaN</span><span class="s3">(</span><span class="s1">x</span><span class="s3">)) </span><span class="s2">throw new </span><span class="s1">IllegalArgumentException</span><span class="s3">(</span><span class="s1">name </span><span class="s3">+ </span><span class="s8">&quot; is NaN&quot;</span><span class="s3">);</span>
        <span class="s2">if </span><span class="s3">(</span><span class="s1">Double</span><span class="s3">.</span><span class="s1">isInfinite</span><span class="s3">(</span><span class="s1">x</span><span class="s3">)) </span><span class="s2">throw new </span><span class="s1">IllegalArgumentException</span><span class="s3">(</span><span class="s1">name </span><span class="s3">+ </span><span class="s8">&quot; is infinite&quot;</span><span class="s3">);</span>
    <span class="s3">}</span>

    <span class="s7">// throw an IllegalArgumentException if s is null</span>
    <span class="s2">private static void </span><span class="s1">validateNonnegative</span><span class="s3">(</span><span class="s2">double </span><span class="s1">x</span><span class="s3">, </span><span class="s1">String name</span><span class="s3">) {</span>
        <span class="s2">if </span><span class="s3">(</span><span class="s1">x </span><span class="s3">&lt; </span><span class="s6">0</span><span class="s3">) </span><span class="s2">throw new </span><span class="s1">IllegalArgumentException</span><span class="s3">(</span><span class="s1">name </span><span class="s3">+ </span><span class="s8">&quot; negative&quot;</span><span class="s3">);</span>
    <span class="s3">}</span>

    <span class="s7">// throw an IllegalArgumentException if s is null</span>
    <span class="s2">private static void </span><span class="s1">validateNotNull</span><span class="s3">(</span><span class="s1">Object x</span><span class="s3">, </span><span class="s1">String name</span><span class="s3">) {</span>
        <span class="s2">if </span><span class="s3">(</span><span class="s1">x </span><span class="s3">== </span><span class="s2">null</span><span class="s3">) </span><span class="s2">throw new </span><span class="s1">IllegalArgumentException</span><span class="s3">(</span><span class="s1">name </span><span class="s3">+ </span><span class="s8">&quot; is null&quot;</span><span class="s3">);</span>
    <span class="s3">}</span>


    <span class="s0">/**</span>
     <span class="s0">* Sets the </span><span class="s5">&lt;em&gt;</span><span class="s0">x</span><span class="s5">&lt;/em&gt;</span><span class="s0">-scale to be the default (between 0.0 and 1.0).</span>
     <span class="s0">*/</span>
    <span class="s2">public static void </span><span class="s1">setXscale</span><span class="s3">() {</span>
        <span class="s1">setXscale</span><span class="s3">(</span><span class="s1">DEFAULT_XMIN</span><span class="s3">, </span><span class="s1">DEFAULT_XMAX</span><span class="s3">);</span>
    <span class="s3">}</span>

    <span class="s0">/**</span>
     <span class="s0">* Sets the </span><span class="s5">&lt;em&gt;</span><span class="s0">y</span><span class="s5">&lt;/em&gt;</span><span class="s0">-scale to be the default (between 0.0 and 1.0).</span>
     <span class="s0">*/</span>
    <span class="s2">public static void </span><span class="s1">setYscale</span><span class="s3">() {</span>
        <span class="s1">setYscale</span><span class="s3">(</span><span class="s1">DEFAULT_YMIN</span><span class="s3">, </span><span class="s1">DEFAULT_YMAX</span><span class="s3">);</span>
    <span class="s3">}</span>

    <span class="s0">/**</span>
     <span class="s0">* Sets the </span><span class="s5">&lt;em&gt;</span><span class="s0">x</span><span class="s5">&lt;/em&gt;</span><span class="s0">-scale and </span><span class="s5">&lt;em&gt;</span><span class="s0">y</span><span class="s5">&lt;/em&gt;</span><span class="s0">-scale to be the default</span>
     <span class="s0">* (between 0.0 and 1.0).</span>
     <span class="s0">*/</span>
    <span class="s2">public static void </span><span class="s1">setScale</span><span class="s3">() {</span>
        <span class="s1">setXscale</span><span class="s3">();</span>
        <span class="s1">setYscale</span><span class="s3">();</span>
    <span class="s3">}</span>

    <span class="s0">/**</span>
     <span class="s0">* Sets the </span><span class="s5">&lt;em&gt;</span><span class="s0">x</span><span class="s5">&lt;/em&gt;</span><span class="s0">-scale to the specified range.</span>
     <span class="s0">*</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">min the minimum value of the </span><span class="s5">&lt;em&gt;</span><span class="s0">x</span><span class="s5">&lt;/em&gt;</span><span class="s0">-scale</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">max the maximum value of the </span><span class="s5">&lt;em&gt;</span><span class="s0">x</span><span class="s5">&lt;/em&gt;</span><span class="s0">-scale</span>
     <span class="s0">* </span><span class="s4">@throws </span><span class="s0">IllegalArgumentException if {</span><span class="s4">@code </span><span class="s0">(max == min)}</span>
     <span class="s0">* </span><span class="s4">@throws </span><span class="s0">IllegalArgumentException if either {</span><span class="s4">@code </span><span class="s0">min} or {</span><span class="s4">@code </span><span class="s0">max} is either NaN or infinite</span>
     <span class="s0">*/</span>
    <span class="s2">public static void </span><span class="s1">setXscale</span><span class="s3">(</span><span class="s2">double </span><span class="s1">min</span><span class="s3">, </span><span class="s2">double </span><span class="s1">max</span><span class="s3">) {</span>
        <span class="s1">validate</span><span class="s3">(</span><span class="s1">min</span><span class="s3">, </span><span class="s8">&quot;min&quot;</span><span class="s3">);</span>
        <span class="s1">validate</span><span class="s3">(</span><span class="s1">max</span><span class="s3">, </span><span class="s8">&quot;max&quot;</span><span class="s3">);</span>
        <span class="s2">double </span><span class="s1">size </span><span class="s3">= </span><span class="s1">max </span><span class="s3">- </span><span class="s1">min</span><span class="s3">;</span>
        <span class="s2">if </span><span class="s3">(</span><span class="s1">size </span><span class="s3">== </span><span class="s6">0.0</span><span class="s3">) </span><span class="s2">throw new </span><span class="s1">IllegalArgumentException</span><span class="s3">(</span><span class="s8">&quot;the min and max are the same&quot;</span><span class="s3">);</span>
        <span class="s2">synchronized </span><span class="s3">(</span><span class="s1">mouseLock</span><span class="s3">) {</span>
            <span class="s1">xmin </span><span class="s3">= </span><span class="s1">min </span><span class="s3">- </span><span class="s1">BORDER </span><span class="s3">* </span><span class="s1">size</span><span class="s3">;</span>
            <span class="s1">xmax </span><span class="s3">= </span><span class="s1">max </span><span class="s3">+ </span><span class="s1">BORDER </span><span class="s3">* </span><span class="s1">size</span><span class="s3">;</span>
        <span class="s3">}</span>
    <span class="s3">}</span>

    <span class="s0">/**</span>
     <span class="s0">* Sets the </span><span class="s5">&lt;em&gt;</span><span class="s0">y</span><span class="s5">&lt;/em&gt;</span><span class="s0">-scale to the specified range.</span>
     <span class="s0">*</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">min the minimum value of the </span><span class="s5">&lt;em&gt;</span><span class="s0">y</span><span class="s5">&lt;/em&gt;</span><span class="s0">-scale</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">max the maximum value of the </span><span class="s5">&lt;em&gt;</span><span class="s0">y</span><span class="s5">&lt;/em&gt;</span><span class="s0">-scale</span>
     <span class="s0">* </span><span class="s4">@throws </span><span class="s0">IllegalArgumentException if {</span><span class="s4">@code </span><span class="s0">(max == min)}</span>
     <span class="s0">* </span><span class="s4">@throws </span><span class="s0">IllegalArgumentException if either {</span><span class="s4">@code </span><span class="s0">min} or {</span><span class="s4">@code </span><span class="s0">max} is either NaN or infinite</span>
     <span class="s0">*/</span>
    <span class="s2">public static void </span><span class="s1">setYscale</span><span class="s3">(</span><span class="s2">double </span><span class="s1">min</span><span class="s3">, </span><span class="s2">double </span><span class="s1">max</span><span class="s3">) {</span>
        <span class="s1">validate</span><span class="s3">(</span><span class="s1">min</span><span class="s3">, </span><span class="s8">&quot;min&quot;</span><span class="s3">);</span>
        <span class="s1">validate</span><span class="s3">(</span><span class="s1">max</span><span class="s3">, </span><span class="s8">&quot;max&quot;</span><span class="s3">);</span>
        <span class="s2">double </span><span class="s1">size </span><span class="s3">= </span><span class="s1">max </span><span class="s3">- </span><span class="s1">min</span><span class="s3">;</span>
        <span class="s2">if </span><span class="s3">(</span><span class="s1">size </span><span class="s3">== </span><span class="s6">0.0</span><span class="s3">) </span><span class="s2">throw new </span><span class="s1">IllegalArgumentException</span><span class="s3">(</span><span class="s8">&quot;the min and max are the same&quot;</span><span class="s3">);</span>
        <span class="s2">synchronized </span><span class="s3">(</span><span class="s1">mouseLock</span><span class="s3">) {</span>
            <span class="s1">ymin </span><span class="s3">= </span><span class="s1">min </span><span class="s3">- </span><span class="s1">BORDER </span><span class="s3">* </span><span class="s1">size</span><span class="s3">;</span>
            <span class="s1">ymax </span><span class="s3">= </span><span class="s1">max </span><span class="s3">+ </span><span class="s1">BORDER </span><span class="s3">* </span><span class="s1">size</span><span class="s3">;</span>
        <span class="s3">}</span>
    <span class="s3">}</span>

    <span class="s0">/**</span>
     <span class="s0">* Sets both the </span><span class="s5">&lt;em&gt;</span><span class="s0">x</span><span class="s5">&lt;/em&gt;</span><span class="s0">-scale and </span><span class="s5">&lt;em&gt;</span><span class="s0">y</span><span class="s5">&lt;/em&gt;</span><span class="s0">-scale to the (same) specified range.</span>
     <span class="s0">*</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">min the minimum value of the </span><span class="s5">&lt;em&gt;</span><span class="s0">x</span><span class="s5">&lt;/em&gt;</span><span class="s0">- and </span><span class="s5">&lt;em&gt;</span><span class="s0">y</span><span class="s5">&lt;/em&gt;</span><span class="s0">-scales</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">max the maximum value of the </span><span class="s5">&lt;em&gt;</span><span class="s0">x</span><span class="s5">&lt;/em&gt;</span><span class="s0">- and </span><span class="s5">&lt;em&gt;</span><span class="s0">y</span><span class="s5">&lt;/em&gt;</span><span class="s0">-scales</span>
     <span class="s0">* </span><span class="s4">@throws </span><span class="s0">IllegalArgumentException if {</span><span class="s4">@code </span><span class="s0">(max == min)}</span>
     <span class="s0">* </span><span class="s4">@throws </span><span class="s0">IllegalArgumentException if either {</span><span class="s4">@code </span><span class="s0">min} or {</span><span class="s4">@code </span><span class="s0">max} is either NaN or infinite</span>
     <span class="s0">*/</span>
    <span class="s2">public static void </span><span class="s1">setScale</span><span class="s3">(</span><span class="s2">double </span><span class="s1">min</span><span class="s3">, </span><span class="s2">double </span><span class="s1">max</span><span class="s3">) {</span>
        <span class="s1">validate</span><span class="s3">(</span><span class="s1">min</span><span class="s3">, </span><span class="s8">&quot;min&quot;</span><span class="s3">);</span>
        <span class="s1">validate</span><span class="s3">(</span><span class="s1">max</span><span class="s3">, </span><span class="s8">&quot;max&quot;</span><span class="s3">);</span>
        <span class="s2">double </span><span class="s1">size </span><span class="s3">= </span><span class="s1">max </span><span class="s3">- </span><span class="s1">min</span><span class="s3">;</span>
        <span class="s2">if </span><span class="s3">(</span><span class="s1">size </span><span class="s3">== </span><span class="s6">0.0</span><span class="s3">) </span><span class="s2">throw new </span><span class="s1">IllegalArgumentException</span><span class="s3">(</span><span class="s8">&quot;the min and max are the same&quot;</span><span class="s3">);</span>
        <span class="s2">synchronized </span><span class="s3">(</span><span class="s1">mouseLock</span><span class="s3">) {</span>
            <span class="s1">xmin </span><span class="s3">= </span><span class="s1">min </span><span class="s3">- </span><span class="s1">BORDER </span><span class="s3">* </span><span class="s1">size</span><span class="s3">;</span>
            <span class="s1">xmax </span><span class="s3">= </span><span class="s1">max </span><span class="s3">+ </span><span class="s1">BORDER </span><span class="s3">* </span><span class="s1">size</span><span class="s3">;</span>
            <span class="s1">ymin </span><span class="s3">= </span><span class="s1">min </span><span class="s3">- </span><span class="s1">BORDER </span><span class="s3">* </span><span class="s1">size</span><span class="s3">;</span>
            <span class="s1">ymax </span><span class="s3">= </span><span class="s1">max </span><span class="s3">+ </span><span class="s1">BORDER </span><span class="s3">* </span><span class="s1">size</span><span class="s3">;</span>
        <span class="s3">}</span>
    <span class="s3">}</span>

    <span class="s7">// helper functions that scale from user coordinates to screen coordinates and back</span>
    <span class="s2">private static double  </span><span class="s1">scaleX</span><span class="s3">(</span><span class="s2">double </span><span class="s1">x</span><span class="s3">) { </span><span class="s2">return </span><span class="s1">width  </span><span class="s3">* (</span><span class="s1">x </span><span class="s3">- </span><span class="s1">xmin</span><span class="s3">) / (</span><span class="s1">xmax </span><span class="s3">- </span><span class="s1">xmin</span><span class="s3">); }</span>
    <span class="s2">private static double  </span><span class="s1">scaleY</span><span class="s3">(</span><span class="s2">double </span><span class="s1">y</span><span class="s3">) { </span><span class="s2">return </span><span class="s1">height </span><span class="s3">* (</span><span class="s1">ymax </span><span class="s3">- </span><span class="s1">y</span><span class="s3">) / (</span><span class="s1">ymax </span><span class="s3">- </span><span class="s1">ymin</span><span class="s3">); }</span>
    <span class="s2">private static double </span><span class="s1">factorX</span><span class="s3">(</span><span class="s2">double </span><span class="s1">w</span><span class="s3">) { </span><span class="s2">return </span><span class="s1">w </span><span class="s3">* </span><span class="s1">width  </span><span class="s3">/ </span><span class="s1">Math</span><span class="s3">.</span><span class="s1">abs</span><span class="s3">(</span><span class="s1">xmax </span><span class="s3">- </span><span class="s1">xmin</span><span class="s3">);  }</span>
    <span class="s2">private static double </span><span class="s1">factorY</span><span class="s3">(</span><span class="s2">double </span><span class="s1">h</span><span class="s3">) { </span><span class="s2">return </span><span class="s1">h </span><span class="s3">* </span><span class="s1">height </span><span class="s3">/ </span><span class="s1">Math</span><span class="s3">.</span><span class="s1">abs</span><span class="s3">(</span><span class="s1">ymax </span><span class="s3">- </span><span class="s1">ymin</span><span class="s3">);  }</span>
    <span class="s2">private static double   </span><span class="s1">userX</span><span class="s3">(</span><span class="s2">double </span><span class="s1">x</span><span class="s3">) { </span><span class="s2">return </span><span class="s1">xmin </span><span class="s3">+ </span><span class="s1">x </span><span class="s3">* (</span><span class="s1">xmax </span><span class="s3">- </span><span class="s1">xmin</span><span class="s3">) / </span><span class="s1">width</span><span class="s3">;    }</span>
    <span class="s2">private static double   </span><span class="s1">userY</span><span class="s3">(</span><span class="s2">double </span><span class="s1">y</span><span class="s3">) { </span><span class="s2">return </span><span class="s1">ymax </span><span class="s3">- </span><span class="s1">y </span><span class="s3">* (</span><span class="s1">ymax </span><span class="s3">- </span><span class="s1">ymin</span><span class="s3">) / </span><span class="s1">height</span><span class="s3">;   }</span>


    <span class="s0">/**</span>
     <span class="s0">* Clears the screen to the default color (white).</span>
     <span class="s0">*/</span>
    <span class="s2">public static void </span><span class="s1">clear</span><span class="s3">() {</span>
        <span class="s1">clear</span><span class="s3">(</span><span class="s1">DEFAULT_CLEAR_COLOR</span><span class="s3">);</span>
    <span class="s3">}</span>

    <span class="s0">/**</span>
     <span class="s0">* Clears the screen to the specified color.</span>
     <span class="s0">*</span>
     <span class="s0">* </span><span class="s4">@param </span><span class="s0">color the color to make the background</span>
     <span class="s0">* </span><span class="s4">@throws </span><span class="s0">IllegalArgumentException if {</span><span class="s4">@code </span><span class="s0">color} is {</span><span class="s4">@code </span><span class="s0">null}</span>
     <span class="s0">*/</span>
    <span class="s2">public static void </span><span class="s1">clear</span><span class="s3">(</span><span class="s1">Color color</span><span class="s3">) {</span>
        <span class="s1">validateNotNull</span><span class="s3">(</span><span class="s1">color</span><span class="s3">, </span><span class="s8">&quot;color&quot;</span><span class="s3">);</span>
        <span class="s1">offscreen</span><span class="s3">.</span><span class="s1">setColor</span><span class="s3">(</span><span class="s1">color</span><span class="s3">);</span>
        <span class="s1">offscreen</span><span class="s3">.</span><span class="s1">fillRect</span><span class="s3">(</span><span class="s6">0</span><span class="s3">, </span><span class="s6">0</span><span class="s3">, </span><span class="s1">width</span><span class="s3">, </span><span class="s1">height</span><span class="s3">);</span>
        <span class="s1">offscreen</span><span class="s3">.</span><span class="s1">setColor</span><span class="s3">(</span><span class="s1">penColor</span><span class="s3">);</span>
        <span class="s1">draw</span><span class="s3">();</span>
    <span class="s3">}</span>

    <span class="s0">/**</span>
     <span class="s0">* Returns the current pen radius.</span>
     <span class="s0">*</span>
     <span class="s0">* </span><span class="s4">@return </span><span class="s0">the current value of the pen radius</span>
     <span class="s0">*/</span>
    <span class="s2">public static double </span><span class="s1">getPenRadius</span><span class="s3">() {</span>
        <span class="s2">return </span><span class="s1">penRadius</span><span class="s3">;</span>
    <span class="s3">}</span>

    <span class="s0">/**</span>
     <span class="s0">* Sets the pen size to the default size (0.002).</span>
     <span class="s0">* The pen is circular, so that lines have rounded ends, and when you set the</span>
     <span class="s0">* pen radius and draw a point, you get a circle of the specified radius.</span>
     <span class="s0">* The pen radius is not affected by coordinate scaling.</span>
     <span class="s0">*/</span>
    <span class="s2">public static void </span><span class="s1">setPenRadius</span><span class="s3">() {</span>
        <span class="s1">setPenRadius</span><span class="s3">(</span><span class="s1">DEFAULT_PEN_RADIUS</span><span class="s3">);</span>
    <span class="s3">}</span>

    <span class="s0">/**</span>
     <span class="s0">* Sets the radius of the pen to the specified size.</span>
     <span class="s0">* The pen is circular, so that lines have rounded ends, and when you set the</span>
     <span class="s0">* pen radius and draw a point, you get a circle of the specified radius.</span>
     <span class="s0">* The pen radius is not affected by coordinate scaling.</span>
     <span class="s0">*</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">radius the radius of the pen</span>
     <span class="s0">* </span><span class="s4">@throws </span><span class="s0">IllegalArgumentException if {</span><span class="s4">@code </span><span class="s0">radius} is negative, NaN, or infinite</span>
     <span class="s0">*/</span>
    <span class="s2">public static void </span><span class="s1">setPenRadius</span><span class="s3">(</span><span class="s2">double </span><span class="s1">radius</span><span class="s3">) {</span>
        <span class="s1">validate</span><span class="s3">(</span><span class="s1">radius</span><span class="s3">, </span><span class="s8">&quot;pen radius&quot;</span><span class="s3">);</span>
        <span class="s1">validateNonnegative</span><span class="s3">(</span><span class="s1">radius</span><span class="s3">, </span><span class="s8">&quot;pen radius&quot;</span><span class="s3">);</span>

        <span class="s1">penRadius </span><span class="s3">= </span><span class="s1">radius</span><span class="s3">;</span>
        <span class="s2">float </span><span class="s1">scaledPenRadius </span><span class="s3">= (</span><span class="s2">float</span><span class="s3">) (</span><span class="s1">radius </span><span class="s3">* </span><span class="s1">DEFAULT_SIZE</span><span class="s3">);</span>
        <span class="s1">BasicStroke stroke </span><span class="s3">= </span><span class="s2">new </span><span class="s1">BasicStroke</span><span class="s3">(</span><span class="s1">scaledPenRadius</span><span class="s3">, </span><span class="s1">BasicStroke</span><span class="s3">.</span><span class="s1">CAP_ROUND</span><span class="s3">, </span><span class="s1">BasicStroke</span><span class="s3">.</span><span class="s1">JOIN_ROUND</span><span class="s3">);</span>
        <span class="s7">// BasicStroke stroke = new BasicStroke(scaledPenRadius);</span>
        <span class="s1">offscreen</span><span class="s3">.</span><span class="s1">setStroke</span><span class="s3">(</span><span class="s1">stroke</span><span class="s3">);</span>
    <span class="s3">}</span>

    <span class="s0">/**</span>
     <span class="s0">* Returns the current pen color.</span>
     <span class="s0">*</span>
     <span class="s0">* </span><span class="s4">@return </span><span class="s0">the current pen color</span>
     <span class="s0">*/</span>
    <span class="s2">public static </span><span class="s1">Color getPenColor</span><span class="s3">() {</span>
        <span class="s2">return </span><span class="s1">penColor</span><span class="s3">;</span>
    <span class="s3">}</span>

    <span class="s0">/**</span>
     <span class="s0">* Sets the pen color to the default color (black).</span>
     <span class="s0">*/</span>
    <span class="s2">public static void </span><span class="s1">setPenColor</span><span class="s3">() {</span>
        <span class="s1">setPenColor</span><span class="s3">(</span><span class="s1">DEFAULT_PEN_COLOR</span><span class="s3">);</span>
    <span class="s3">}</span>

    <span class="s0">/**</span>
     <span class="s0">* Sets the pen color to the specified color.</span>
     <span class="s0">* </span><span class="s5">&lt;p&gt;</span>
     <span class="s0">* The predefined pen colors are</span>
     <span class="s0">* {</span><span class="s4">@code </span><span class="s0">StdDraw.BLACK}, {</span><span class="s4">@code </span><span class="s0">StdDraw.BLUE}, {</span><span class="s4">@code </span><span class="s0">StdDraw.CYAN},</span>
     <span class="s0">* {</span><span class="s4">@code </span><span class="s0">StdDraw.DARK_GRAY}, {</span><span class="s4">@code </span><span class="s0">StdDraw.GRAY}, {</span><span class="s4">@code </span><span class="s0">StdDraw.GREEN},</span>
     <span class="s0">* {</span><span class="s4">@code </span><span class="s0">StdDraw.LIGHT_GRAY}, {</span><span class="s4">@code </span><span class="s0">StdDraw.MAGENTA}, {</span><span class="s4">@code </span><span class="s0">StdDraw.ORANGE},</span>
     <span class="s0">* {</span><span class="s4">@code </span><span class="s0">StdDraw.PINK}, {</span><span class="s4">@code </span><span class="s0">StdDraw.RED}, {</span><span class="s4">@code </span><span class="s0">StdDraw.WHITE}, and</span>
     <span class="s0">* {</span><span class="s4">@code </span><span class="s0">StdDraw.YELLOW}.</span>
     <span class="s0">*</span>
     <span class="s0">* </span><span class="s4">@param </span><span class="s0">color the color to make the pen</span>
     <span class="s0">* </span><span class="s4">@throws </span><span class="s0">IllegalArgumentException if {</span><span class="s4">@code </span><span class="s0">color} is {</span><span class="s4">@code </span><span class="s0">null}</span>
     <span class="s0">*/</span>
    <span class="s2">public static void </span><span class="s1">setPenColor</span><span class="s3">(</span><span class="s1">Color color</span><span class="s3">) {</span>
        <span class="s1">validateNotNull</span><span class="s3">(</span><span class="s1">color</span><span class="s3">, </span><span class="s8">&quot;color&quot;</span><span class="s3">);</span>
        <span class="s1">penColor </span><span class="s3">= </span><span class="s1">color</span><span class="s3">;</span>
        <span class="s1">offscreen</span><span class="s3">.</span><span class="s1">setColor</span><span class="s3">(</span><span class="s1">penColor</span><span class="s3">);</span>
    <span class="s3">}</span>

    <span class="s0">/**</span>
     <span class="s0">* Sets the pen color to the specified RGB color.</span>
     <span class="s0">*</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">red the amount of red (between 0 and 255)</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">green the amount of green (between 0 and 255)</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">blue the amount of blue (between 0 and 255)</span>
     <span class="s0">* </span><span class="s4">@throws </span><span class="s0">IllegalArgumentException if {</span><span class="s4">@code </span><span class="s0">red}, {</span><span class="s4">@code </span><span class="s0">green},</span>
     <span class="s0">*         or {</span><span class="s4">@code </span><span class="s0">blue} is outside its prescribed range</span>
     <span class="s0">*/</span>
    <span class="s2">public static void </span><span class="s1">setPenColor</span><span class="s3">(</span><span class="s2">int </span><span class="s1">red</span><span class="s3">, </span><span class="s2">int </span><span class="s1">green</span><span class="s3">, </span><span class="s2">int </span><span class="s1">blue</span><span class="s3">) {</span>
        <span class="s2">if </span><span class="s3">(</span><span class="s1">red   </span><span class="s3">&lt; </span><span class="s6">0 </span><span class="s3">|| </span><span class="s1">red   </span><span class="s3">&gt;= </span><span class="s6">256</span><span class="s3">) </span><span class="s2">throw new </span><span class="s1">IllegalArgumentException</span><span class="s3">(</span><span class="s8">&quot;red must be between 0 and 255&quot;</span><span class="s3">);</span>
        <span class="s2">if </span><span class="s3">(</span><span class="s1">green </span><span class="s3">&lt; </span><span class="s6">0 </span><span class="s3">|| </span><span class="s1">green </span><span class="s3">&gt;= </span><span class="s6">256</span><span class="s3">) </span><span class="s2">throw new </span><span class="s1">IllegalArgumentException</span><span class="s3">(</span><span class="s8">&quot;green must be between 0 and 255&quot;</span><span class="s3">);</span>
        <span class="s2">if </span><span class="s3">(</span><span class="s1">blue  </span><span class="s3">&lt; </span><span class="s6">0 </span><span class="s3">|| </span><span class="s1">blue  </span><span class="s3">&gt;= </span><span class="s6">256</span><span class="s3">) </span><span class="s2">throw new </span><span class="s1">IllegalArgumentException</span><span class="s3">(</span><span class="s8">&quot;blue must be between 0 and 255&quot;</span><span class="s3">);</span>
        <span class="s1">setPenColor</span><span class="s3">(</span><span class="s2">new </span><span class="s1">Color</span><span class="s3">(</span><span class="s1">red</span><span class="s3">, </span><span class="s1">green</span><span class="s3">, </span><span class="s1">blue</span><span class="s3">));</span>
    <span class="s3">}</span>

    <span class="s0">/**</span>
     <span class="s0">* Returns the current font.</span>
     <span class="s0">*</span>
     <span class="s0">* </span><span class="s4">@return </span><span class="s0">the current font</span>
     <span class="s0">*/</span>
    <span class="s2">public static </span><span class="s1">Font getFont</span><span class="s3">() {</span>
        <span class="s2">return </span><span class="s1">font</span><span class="s3">;</span>
    <span class="s3">}</span>

    <span class="s0">/**</span>
     <span class="s0">* Sets the font to the default font (sans serif, 16 point).</span>
     <span class="s0">*/</span>
    <span class="s2">public static void </span><span class="s1">setFont</span><span class="s3">() {</span>
        <span class="s1">setFont</span><span class="s3">(</span><span class="s1">DEFAULT_FONT</span><span class="s3">);</span>
    <span class="s3">}</span>

    <span class="s0">/**</span>
     <span class="s0">* Sets the font to the specified value.</span>
     <span class="s0">*</span>
     <span class="s0">* </span><span class="s4">@param </span><span class="s0">font the font</span>
     <span class="s0">* </span><span class="s4">@throws </span><span class="s0">IllegalArgumentException if {</span><span class="s4">@code </span><span class="s0">font} is {</span><span class="s4">@code </span><span class="s0">null}</span>
     <span class="s0">*/</span>
    <span class="s2">public static void </span><span class="s1">setFont</span><span class="s3">(</span><span class="s1">Font font</span><span class="s3">) {</span>
        <span class="s1">validateNotNull</span><span class="s3">(</span><span class="s1">font</span><span class="s3">, </span><span class="s8">&quot;font&quot;</span><span class="s3">);</span>
        <span class="s1">StdDraw</span><span class="s3">.</span><span class="s1">font </span><span class="s3">= </span><span class="s1">font</span><span class="s3">;</span>
    <span class="s3">}</span>


    <span class="s0">/***************************************************************************</span>
     <span class="s0">*  Drawing geometric shapes.</span>
     <span class="s0">***************************************************************************/</span>

    <span class="s0">/**</span>
     <span class="s0">* Draws a line segment between (</span><span class="s5">&lt;em&gt;</span><span class="s0">x</span><span class="s5">&lt;/em&gt;&lt;sub&gt;</span><span class="s0">0</span><span class="s5">&lt;/sub&gt;</span><span class="s0">, </span><span class="s5">&lt;em&gt;</span><span class="s0">y</span><span class="s5">&lt;/em&gt;&lt;sub&gt;</span><span class="s0">0</span><span class="s5">&lt;/sub&gt;</span><span class="s0">) and</span>
     <span class="s0">* (</span><span class="s5">&lt;em&gt;</span><span class="s0">x</span><span class="s5">&lt;/em&gt;&lt;sub&gt;</span><span class="s0">1</span><span class="s5">&lt;/sub&gt;</span><span class="s0">, </span><span class="s5">&lt;em&gt;</span><span class="s0">y</span><span class="s5">&lt;/em&gt;&lt;sub&gt;</span><span class="s0">1</span><span class="s5">&lt;/sub&gt;</span><span class="s0">).</span>
     <span class="s0">*</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">x0 the </span><span class="s5">&lt;em&gt;</span><span class="s0">x</span><span class="s5">&lt;/em&gt;</span><span class="s0">-coordinate of one endpoint</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">y0 the </span><span class="s5">&lt;em&gt;</span><span class="s0">y</span><span class="s5">&lt;/em&gt;</span><span class="s0">-coordinate of one endpoint</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">x1 the </span><span class="s5">&lt;em&gt;</span><span class="s0">x</span><span class="s5">&lt;/em&gt;</span><span class="s0">-coordinate of the other endpoint</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">y1 the </span><span class="s5">&lt;em&gt;</span><span class="s0">y</span><span class="s5">&lt;/em&gt;</span><span class="s0">-coordinate of the other endpoint</span>
     <span class="s0">* </span><span class="s4">@throws </span><span class="s0">IllegalArgumentException if any coordinate is either NaN or infinite</span>
     <span class="s0">*/</span>
    <span class="s2">public static void </span><span class="s1">line</span><span class="s3">(</span><span class="s2">double </span><span class="s1">x0</span><span class="s3">, </span><span class="s2">double </span><span class="s1">y0</span><span class="s3">, </span><span class="s2">double </span><span class="s1">x1</span><span class="s3">, </span><span class="s2">double </span><span class="s1">y1</span><span class="s3">) {</span>
        <span class="s1">validate</span><span class="s3">(</span><span class="s1">x0</span><span class="s3">, </span><span class="s8">&quot;x0&quot;</span><span class="s3">);</span>
        <span class="s1">validate</span><span class="s3">(</span><span class="s1">y0</span><span class="s3">, </span><span class="s8">&quot;y0&quot;</span><span class="s3">);</span>
        <span class="s1">validate</span><span class="s3">(</span><span class="s1">x1</span><span class="s3">, </span><span class="s8">&quot;x1&quot;</span><span class="s3">);</span>
        <span class="s1">validate</span><span class="s3">(</span><span class="s1">y1</span><span class="s3">, </span><span class="s8">&quot;y1&quot;</span><span class="s3">);</span>
        <span class="s1">offscreen</span><span class="s3">.</span><span class="s1">draw</span><span class="s3">(</span><span class="s2">new </span><span class="s1">Line2D</span><span class="s3">.</span><span class="s1">Double</span><span class="s3">(</span><span class="s1">scaleX</span><span class="s3">(</span><span class="s1">x0</span><span class="s3">), </span><span class="s1">scaleY</span><span class="s3">(</span><span class="s1">y0</span><span class="s3">), </span><span class="s1">scaleX</span><span class="s3">(</span><span class="s1">x1</span><span class="s3">), </span><span class="s1">scaleY</span><span class="s3">(</span><span class="s1">y1</span><span class="s3">)));</span>
        <span class="s1">draw</span><span class="s3">();</span>
    <span class="s3">}</span>

    <span class="s0">/**</span>
     <span class="s0">* Draws one pixel at (</span><span class="s5">&lt;em&gt;</span><span class="s0">x</span><span class="s5">&lt;/em&gt;</span><span class="s0">, </span><span class="s5">&lt;em&gt;</span><span class="s0">y</span><span class="s5">&lt;/em&gt;</span><span class="s0">).</span>
     <span class="s0">* This method is private because pixels depend on the display.</span>
     <span class="s0">* To achieve the same effect, set the pen radius to 0 and call {</span><span class="s4">@code </span><span class="s0">point()}.</span>
     <span class="s0">*</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">x the </span><span class="s5">&lt;em&gt;</span><span class="s0">x</span><span class="s5">&lt;/em&gt;</span><span class="s0">-coordinate of the pixel</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">y the </span><span class="s5">&lt;em&gt;</span><span class="s0">y</span><span class="s5">&lt;/em&gt;</span><span class="s0">-coordinate of the pixel</span>
     <span class="s0">* </span><span class="s4">@throws </span><span class="s0">IllegalArgumentException if {</span><span class="s4">@code </span><span class="s0">x} or {</span><span class="s4">@code </span><span class="s0">y} is either NaN or infinite</span>
     <span class="s0">*/</span>
    <span class="s2">private static void </span><span class="s1">pixel</span><span class="s3">(</span><span class="s2">double </span><span class="s1">x</span><span class="s3">, </span><span class="s2">double </span><span class="s1">y</span><span class="s3">) {</span>
        <span class="s1">validate</span><span class="s3">(</span><span class="s1">x</span><span class="s3">, </span><span class="s8">&quot;x&quot;</span><span class="s3">);</span>
        <span class="s1">validate</span><span class="s3">(</span><span class="s1">y</span><span class="s3">, </span><span class="s8">&quot;y&quot;</span><span class="s3">);</span>
        <span class="s1">offscreen</span><span class="s3">.</span><span class="s1">fillRect</span><span class="s3">((</span><span class="s2">int</span><span class="s3">) </span><span class="s1">Math</span><span class="s3">.</span><span class="s1">round</span><span class="s3">(</span><span class="s1">scaleX</span><span class="s3">(</span><span class="s1">x</span><span class="s3">)), (</span><span class="s2">int</span><span class="s3">) </span><span class="s1">Math</span><span class="s3">.</span><span class="s1">round</span><span class="s3">(</span><span class="s1">scaleY</span><span class="s3">(</span><span class="s1">y</span><span class="s3">)), </span><span class="s6">1</span><span class="s3">, </span><span class="s6">1</span><span class="s3">);</span>
    <span class="s3">}</span>

    <span class="s0">/**</span>
     <span class="s0">* Draws a point centered at (</span><span class="s5">&lt;em&gt;</span><span class="s0">x</span><span class="s5">&lt;/em&gt;</span><span class="s0">, </span><span class="s5">&lt;em&gt;</span><span class="s0">y</span><span class="s5">&lt;/em&gt;</span><span class="s0">).</span>
     <span class="s0">* The point is a filled circle whose radius is equal to the pen radius.</span>
     <span class="s0">* To draw a single-pixel point, first set the pen radius to 0.</span>
     <span class="s0">*</span>
     <span class="s0">* </span><span class="s4">@param </span><span class="s0">x the </span><span class="s5">&lt;em&gt;</span><span class="s0">x</span><span class="s5">&lt;/em&gt;</span><span class="s0">-coordinate of the point</span>
     <span class="s0">* </span><span class="s4">@param </span><span class="s0">y the </span><span class="s5">&lt;em&gt;</span><span class="s0">y</span><span class="s5">&lt;/em&gt;</span><span class="s0">-coordinate of the point</span>
     <span class="s0">* </span><span class="s4">@throws </span><span class="s0">IllegalArgumentException if either {</span><span class="s4">@code </span><span class="s0">x} or {</span><span class="s4">@code </span><span class="s0">y} is either NaN or infinite</span>
     <span class="s0">*/</span>
    <span class="s2">public static void </span><span class="s1">point</span><span class="s3">(</span><span class="s2">double </span><span class="s1">x</span><span class="s3">, </span><span class="s2">double </span><span class="s1">y</span><span class="s3">) {</span>
        <span class="s1">validate</span><span class="s3">(</span><span class="s1">x</span><span class="s3">, </span><span class="s8">&quot;x&quot;</span><span class="s3">);</span>
        <span class="s1">validate</span><span class="s3">(</span><span class="s1">y</span><span class="s3">, </span><span class="s8">&quot;y&quot;</span><span class="s3">);</span>

        <span class="s2">double </span><span class="s1">xs </span><span class="s3">= </span><span class="s1">scaleX</span><span class="s3">(</span><span class="s1">x</span><span class="s3">);</span>
        <span class="s2">double </span><span class="s1">ys </span><span class="s3">= </span><span class="s1">scaleY</span><span class="s3">(</span><span class="s1">y</span><span class="s3">);</span>
        <span class="s2">double </span><span class="s1">r </span><span class="s3">= </span><span class="s1">penRadius</span><span class="s3">;</span>
        <span class="s2">float </span><span class="s1">scaledPenRadius </span><span class="s3">= (</span><span class="s2">float</span><span class="s3">) (</span><span class="s1">r </span><span class="s3">* </span><span class="s1">DEFAULT_SIZE</span><span class="s3">);</span>

        <span class="s7">// double ws = factorX(2*r);</span>
        <span class="s7">// double hs = factorY(2*r);</span>
        <span class="s7">// if (ws &lt;= 1 &amp;&amp; hs &lt;= 1) pixel(x, y);</span>
        <span class="s2">if </span><span class="s3">(</span><span class="s1">scaledPenRadius </span><span class="s3">&lt;= </span><span class="s6">1</span><span class="s3">) </span><span class="s1">pixel</span><span class="s3">(</span><span class="s1">x</span><span class="s3">, </span><span class="s1">y</span><span class="s3">);</span>
        <span class="s2">else </span><span class="s1">offscreen</span><span class="s3">.</span><span class="s1">fill</span><span class="s3">(</span><span class="s2">new </span><span class="s1">Ellipse2D</span><span class="s3">.</span><span class="s1">Double</span><span class="s3">(</span><span class="s1">xs </span><span class="s3">- </span><span class="s1">scaledPenRadius</span><span class="s3">/</span><span class="s6">2</span><span class="s3">, </span><span class="s1">ys </span><span class="s3">- </span><span class="s1">scaledPenRadius</span><span class="s3">/</span><span class="s6">2</span><span class="s3">,</span>
                <span class="s1">scaledPenRadius</span><span class="s3">, </span><span class="s1">scaledPenRadius</span><span class="s3">));</span>
        <span class="s1">draw</span><span class="s3">();</span>
    <span class="s3">}</span>

    <span class="s0">/**</span>
     <span class="s0">* Draws a circle of the specified radius, centered at (</span><span class="s5">&lt;em&gt;</span><span class="s0">x</span><span class="s5">&lt;/em&gt;</span><span class="s0">, </span><span class="s5">&lt;em&gt;</span><span class="s0">y</span><span class="s5">&lt;/em&gt;</span><span class="s0">).</span>
     <span class="s0">*</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">x the </span><span class="s5">&lt;em&gt;</span><span class="s0">x</span><span class="s5">&lt;/em&gt;</span><span class="s0">-coordinate of the center of the circle</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">y the </span><span class="s5">&lt;em&gt;</span><span class="s0">y</span><span class="s5">&lt;/em&gt;</span><span class="s0">-coordinate of the center of the circle</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">radius the radius of the circle</span>
     <span class="s0">* </span><span class="s4">@throws </span><span class="s0">IllegalArgumentException if {</span><span class="s4">@code </span><span class="s0">radius} is negative</span>
     <span class="s0">* </span><span class="s4">@throws </span><span class="s0">IllegalArgumentException if any argument is either NaN or infinite</span>
     <span class="s0">*/</span>
    <span class="s2">public static void </span><span class="s1">circle</span><span class="s3">(</span><span class="s2">double </span><span class="s1">x</span><span class="s3">, </span><span class="s2">double </span><span class="s1">y</span><span class="s3">, </span><span class="s2">double </span><span class="s1">radius</span><span class="s3">) {</span>
        <span class="s1">validate</span><span class="s3">(</span><span class="s1">x</span><span class="s3">, </span><span class="s8">&quot;x&quot;</span><span class="s3">);</span>
        <span class="s1">validate</span><span class="s3">(</span><span class="s1">y</span><span class="s3">, </span><span class="s8">&quot;y&quot;</span><span class="s3">);</span>
        <span class="s1">validate</span><span class="s3">(</span><span class="s1">radius</span><span class="s3">, </span><span class="s8">&quot;radius&quot;</span><span class="s3">);</span>
        <span class="s1">validateNonnegative</span><span class="s3">(</span><span class="s1">radius</span><span class="s3">, </span><span class="s8">&quot;radius&quot;</span><span class="s3">);</span>

        <span class="s2">double </span><span class="s1">xs </span><span class="s3">= </span><span class="s1">scaleX</span><span class="s3">(</span><span class="s1">x</span><span class="s3">);</span>
        <span class="s2">double </span><span class="s1">ys </span><span class="s3">= </span><span class="s1">scaleY</span><span class="s3">(</span><span class="s1">y</span><span class="s3">);</span>
        <span class="s2">double </span><span class="s1">ws </span><span class="s3">= </span><span class="s1">factorX</span><span class="s3">(</span><span class="s6">2</span><span class="s3">*</span><span class="s1">radius</span><span class="s3">);</span>
        <span class="s2">double </span><span class="s1">hs </span><span class="s3">= </span><span class="s1">factorY</span><span class="s3">(</span><span class="s6">2</span><span class="s3">*</span><span class="s1">radius</span><span class="s3">);</span>
        <span class="s2">if </span><span class="s3">(</span><span class="s1">ws </span><span class="s3">&lt;= </span><span class="s6">1 </span><span class="s3">&amp;&amp; </span><span class="s1">hs </span><span class="s3">&lt;= </span><span class="s6">1</span><span class="s3">) </span><span class="s1">pixel</span><span class="s3">(</span><span class="s1">x</span><span class="s3">, </span><span class="s1">y</span><span class="s3">);</span>
        <span class="s2">else </span><span class="s1">offscreen</span><span class="s3">.</span><span class="s1">draw</span><span class="s3">(</span><span class="s2">new </span><span class="s1">Ellipse2D</span><span class="s3">.</span><span class="s1">Double</span><span class="s3">(</span><span class="s1">xs </span><span class="s3">- </span><span class="s1">ws</span><span class="s3">/</span><span class="s6">2</span><span class="s3">, </span><span class="s1">ys </span><span class="s3">- </span><span class="s1">hs</span><span class="s3">/</span><span class="s6">2</span><span class="s3">, </span><span class="s1">ws</span><span class="s3">, </span><span class="s1">hs</span><span class="s3">));</span>
        <span class="s1">draw</span><span class="s3">();</span>
    <span class="s3">}</span>

    <span class="s0">/**</span>
     <span class="s0">* Draws a filled circle of the specified radius, centered at (</span><span class="s5">&lt;em&gt;</span><span class="s0">x</span><span class="s5">&lt;/em&gt;</span><span class="s0">, </span><span class="s5">&lt;em&gt;</span><span class="s0">y</span><span class="s5">&lt;/em&gt;</span><span class="s0">).</span>
     <span class="s0">*</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">x the </span><span class="s5">&lt;em&gt;</span><span class="s0">x</span><span class="s5">&lt;/em&gt;</span><span class="s0">-coordinate of the center of the circle</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">y the </span><span class="s5">&lt;em&gt;</span><span class="s0">y</span><span class="s5">&lt;/em&gt;</span><span class="s0">-coordinate of the center of the circle</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">radius the radius of the circle</span>
     <span class="s0">* </span><span class="s4">@throws </span><span class="s0">IllegalArgumentException if {</span><span class="s4">@code </span><span class="s0">radius} is negative</span>
     <span class="s0">* </span><span class="s4">@throws </span><span class="s0">IllegalArgumentException if any argument is either NaN or infinite</span>
     <span class="s0">*/</span>
    <span class="s2">public static void </span><span class="s1">filledCircle</span><span class="s3">(</span><span class="s2">double </span><span class="s1">x</span><span class="s3">, </span><span class="s2">double </span><span class="s1">y</span><span class="s3">, </span><span class="s2">double </span><span class="s1">radius</span><span class="s3">) {</span>
        <span class="s1">validate</span><span class="s3">(</span><span class="s1">x</span><span class="s3">, </span><span class="s8">&quot;x&quot;</span><span class="s3">);</span>
        <span class="s1">validate</span><span class="s3">(</span><span class="s1">y</span><span class="s3">, </span><span class="s8">&quot;y&quot;</span><span class="s3">);</span>
        <span class="s1">validate</span><span class="s3">(</span><span class="s1">radius</span><span class="s3">, </span><span class="s8">&quot;radius&quot;</span><span class="s3">);</span>
        <span class="s1">validateNonnegative</span><span class="s3">(</span><span class="s1">radius</span><span class="s3">, </span><span class="s8">&quot;radius&quot;</span><span class="s3">);</span>

        <span class="s2">double </span><span class="s1">xs </span><span class="s3">= </span><span class="s1">scaleX</span><span class="s3">(</span><span class="s1">x</span><span class="s3">);</span>
        <span class="s2">double </span><span class="s1">ys </span><span class="s3">= </span><span class="s1">scaleY</span><span class="s3">(</span><span class="s1">y</span><span class="s3">);</span>
        <span class="s2">double </span><span class="s1">ws </span><span class="s3">= </span><span class="s1">factorX</span><span class="s3">(</span><span class="s6">2</span><span class="s3">*</span><span class="s1">radius</span><span class="s3">);</span>
        <span class="s2">double </span><span class="s1">hs </span><span class="s3">= </span><span class="s1">factorY</span><span class="s3">(</span><span class="s6">2</span><span class="s3">*</span><span class="s1">radius</span><span class="s3">);</span>
        <span class="s2">if </span><span class="s3">(</span><span class="s1">ws </span><span class="s3">&lt;= </span><span class="s6">1 </span><span class="s3">&amp;&amp; </span><span class="s1">hs </span><span class="s3">&lt;= </span><span class="s6">1</span><span class="s3">) </span><span class="s1">pixel</span><span class="s3">(</span><span class="s1">x</span><span class="s3">, </span><span class="s1">y</span><span class="s3">);</span>
        <span class="s2">else </span><span class="s1">offscreen</span><span class="s3">.</span><span class="s1">fill</span><span class="s3">(</span><span class="s2">new </span><span class="s1">Ellipse2D</span><span class="s3">.</span><span class="s1">Double</span><span class="s3">(</span><span class="s1">xs </span><span class="s3">- </span><span class="s1">ws</span><span class="s3">/</span><span class="s6">2</span><span class="s3">, </span><span class="s1">ys </span><span class="s3">- </span><span class="s1">hs</span><span class="s3">/</span><span class="s6">2</span><span class="s3">, </span><span class="s1">ws</span><span class="s3">, </span><span class="s1">hs</span><span class="s3">));</span>
        <span class="s1">draw</span><span class="s3">();</span>
    <span class="s3">}</span>


    <span class="s0">/**</span>
     <span class="s0">* Draws an ellipse with the specified semimajor and semiminor axes,</span>
     <span class="s0">* centered at (</span><span class="s5">&lt;em&gt;</span><span class="s0">x</span><span class="s5">&lt;/em&gt;</span><span class="s0">, </span><span class="s5">&lt;em&gt;</span><span class="s0">y</span><span class="s5">&lt;/em&gt;</span><span class="s0">).</span>
     <span class="s0">*</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">x the </span><span class="s5">&lt;em&gt;</span><span class="s0">x</span><span class="s5">&lt;/em&gt;</span><span class="s0">-coordinate of the center of the ellipse</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">y the </span><span class="s5">&lt;em&gt;</span><span class="s0">y</span><span class="s5">&lt;/em&gt;</span><span class="s0">-coordinate of the center of the ellipse</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">semiMajorAxis is the semimajor axis of the ellipse</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">semiMinorAxis is the semiminor axis of the ellipse</span>
     <span class="s0">* </span><span class="s4">@throws </span><span class="s0">IllegalArgumentException if either {</span><span class="s4">@code </span><span class="s0">semiMajorAxis}</span>
     <span class="s0">*         or {</span><span class="s4">@code </span><span class="s0">semiMinorAxis} is negative</span>
     <span class="s0">* </span><span class="s4">@throws </span><span class="s0">IllegalArgumentException if any argument is either NaN or infinite</span>
     <span class="s0">*/</span>
    <span class="s2">public static void </span><span class="s1">ellipse</span><span class="s3">(</span><span class="s2">double </span><span class="s1">x</span><span class="s3">, </span><span class="s2">double </span><span class="s1">y</span><span class="s3">, </span><span class="s2">double </span><span class="s1">semiMajorAxis</span><span class="s3">, </span><span class="s2">double </span><span class="s1">semiMinorAxis</span><span class="s3">) {</span>
        <span class="s1">validate</span><span class="s3">(</span><span class="s1">x</span><span class="s3">, </span><span class="s8">&quot;x&quot;</span><span class="s3">);</span>
        <span class="s1">validate</span><span class="s3">(</span><span class="s1">y</span><span class="s3">, </span><span class="s8">&quot;y&quot;</span><span class="s3">);</span>
        <span class="s1">validate</span><span class="s3">(</span><span class="s1">semiMajorAxis</span><span class="s3">, </span><span class="s8">&quot;semimajor axis&quot;</span><span class="s3">);</span>
        <span class="s1">validate</span><span class="s3">(</span><span class="s1">semiMinorAxis</span><span class="s3">, </span><span class="s8">&quot;semiminor axis&quot;</span><span class="s3">);</span>
        <span class="s1">validateNonnegative</span><span class="s3">(</span><span class="s1">semiMajorAxis</span><span class="s3">, </span><span class="s8">&quot;semimajor axis&quot;</span><span class="s3">);</span>
        <span class="s1">validateNonnegative</span><span class="s3">(</span><span class="s1">semiMinorAxis</span><span class="s3">, </span><span class="s8">&quot;semiminor axis&quot;</span><span class="s3">);</span>

        <span class="s2">double </span><span class="s1">xs </span><span class="s3">= </span><span class="s1">scaleX</span><span class="s3">(</span><span class="s1">x</span><span class="s3">);</span>
        <span class="s2">double </span><span class="s1">ys </span><span class="s3">= </span><span class="s1">scaleY</span><span class="s3">(</span><span class="s1">y</span><span class="s3">);</span>
        <span class="s2">double </span><span class="s1">ws </span><span class="s3">= </span><span class="s1">factorX</span><span class="s3">(</span><span class="s6">2</span><span class="s3">*</span><span class="s1">semiMajorAxis</span><span class="s3">);</span>
        <span class="s2">double </span><span class="s1">hs </span><span class="s3">= </span><span class="s1">factorY</span><span class="s3">(</span><span class="s6">2</span><span class="s3">*</span><span class="s1">semiMinorAxis</span><span class="s3">);</span>
        <span class="s2">if </span><span class="s3">(</span><span class="s1">ws </span><span class="s3">&lt;= </span><span class="s6">1 </span><span class="s3">&amp;&amp; </span><span class="s1">hs </span><span class="s3">&lt;= </span><span class="s6">1</span><span class="s3">) </span><span class="s1">pixel</span><span class="s3">(</span><span class="s1">x</span><span class="s3">, </span><span class="s1">y</span><span class="s3">);</span>
        <span class="s2">else </span><span class="s1">offscreen</span><span class="s3">.</span><span class="s1">draw</span><span class="s3">(</span><span class="s2">new </span><span class="s1">Ellipse2D</span><span class="s3">.</span><span class="s1">Double</span><span class="s3">(</span><span class="s1">xs </span><span class="s3">- </span><span class="s1">ws</span><span class="s3">/</span><span class="s6">2</span><span class="s3">, </span><span class="s1">ys </span><span class="s3">- </span><span class="s1">hs</span><span class="s3">/</span><span class="s6">2</span><span class="s3">, </span><span class="s1">ws</span><span class="s3">, </span><span class="s1">hs</span><span class="s3">));</span>
        <span class="s1">draw</span><span class="s3">();</span>
    <span class="s3">}</span>

    <span class="s0">/**</span>
     <span class="s0">* Draws a filled ellipse with the specified semimajor and semiminor axes,</span>
     <span class="s0">* centered at (</span><span class="s5">&lt;em&gt;</span><span class="s0">x</span><span class="s5">&lt;/em&gt;</span><span class="s0">, </span><span class="s5">&lt;em&gt;</span><span class="s0">y</span><span class="s5">&lt;/em&gt;</span><span class="s0">).</span>
     <span class="s0">*</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">x the </span><span class="s5">&lt;em&gt;</span><span class="s0">x</span><span class="s5">&lt;/em&gt;</span><span class="s0">-coordinate of the center of the ellipse</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">y the </span><span class="s5">&lt;em&gt;</span><span class="s0">y</span><span class="s5">&lt;/em&gt;</span><span class="s0">-coordinate of the center of the ellipse</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">semiMajorAxis is the semimajor axis of the ellipse</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">semiMinorAxis is the semiminor axis of the ellipse</span>
     <span class="s0">* </span><span class="s4">@throws </span><span class="s0">IllegalArgumentException if either {</span><span class="s4">@code </span><span class="s0">semiMajorAxis}</span>
     <span class="s0">*         or {</span><span class="s4">@code </span><span class="s0">semiMinorAxis} is negative</span>
     <span class="s0">* </span><span class="s4">@throws </span><span class="s0">IllegalArgumentException if any argument is either NaN or infinite</span>
     <span class="s0">*/</span>
    <span class="s2">public static void </span><span class="s1">filledEllipse</span><span class="s3">(</span><span class="s2">double </span><span class="s1">x</span><span class="s3">, </span><span class="s2">double </span><span class="s1">y</span><span class="s3">, </span><span class="s2">double </span><span class="s1">semiMajorAxis</span><span class="s3">, </span><span class="s2">double </span><span class="s1">semiMinorAxis</span><span class="s3">) {</span>
        <span class="s1">validate</span><span class="s3">(</span><span class="s1">x</span><span class="s3">, </span><span class="s8">&quot;x&quot;</span><span class="s3">);</span>
        <span class="s1">validate</span><span class="s3">(</span><span class="s1">y</span><span class="s3">, </span><span class="s8">&quot;y&quot;</span><span class="s3">);</span>
        <span class="s1">validate</span><span class="s3">(</span><span class="s1">semiMajorAxis</span><span class="s3">, </span><span class="s8">&quot;semimajor axis&quot;</span><span class="s3">);</span>
        <span class="s1">validate</span><span class="s3">(</span><span class="s1">semiMinorAxis</span><span class="s3">, </span><span class="s8">&quot;semiminor axis&quot;</span><span class="s3">);</span>
        <span class="s1">validateNonnegative</span><span class="s3">(</span><span class="s1">semiMajorAxis</span><span class="s3">, </span><span class="s8">&quot;semimajor axis&quot;</span><span class="s3">);</span>
        <span class="s1">validateNonnegative</span><span class="s3">(</span><span class="s1">semiMinorAxis</span><span class="s3">, </span><span class="s8">&quot;semiminor axis&quot;</span><span class="s3">);</span>

        <span class="s2">double </span><span class="s1">xs </span><span class="s3">= </span><span class="s1">scaleX</span><span class="s3">(</span><span class="s1">x</span><span class="s3">);</span>
        <span class="s2">double </span><span class="s1">ys </span><span class="s3">= </span><span class="s1">scaleY</span><span class="s3">(</span><span class="s1">y</span><span class="s3">);</span>
        <span class="s2">double </span><span class="s1">ws </span><span class="s3">= </span><span class="s1">factorX</span><span class="s3">(</span><span class="s6">2</span><span class="s3">*</span><span class="s1">semiMajorAxis</span><span class="s3">);</span>
        <span class="s2">double </span><span class="s1">hs </span><span class="s3">= </span><span class="s1">factorY</span><span class="s3">(</span><span class="s6">2</span><span class="s3">*</span><span class="s1">semiMinorAxis</span><span class="s3">);</span>
        <span class="s2">if </span><span class="s3">(</span><span class="s1">ws </span><span class="s3">&lt;= </span><span class="s6">1 </span><span class="s3">&amp;&amp; </span><span class="s1">hs </span><span class="s3">&lt;= </span><span class="s6">1</span><span class="s3">) </span><span class="s1">pixel</span><span class="s3">(</span><span class="s1">x</span><span class="s3">, </span><span class="s1">y</span><span class="s3">);</span>
        <span class="s2">else </span><span class="s1">offscreen</span><span class="s3">.</span><span class="s1">fill</span><span class="s3">(</span><span class="s2">new </span><span class="s1">Ellipse2D</span><span class="s3">.</span><span class="s1">Double</span><span class="s3">(</span><span class="s1">xs </span><span class="s3">- </span><span class="s1">ws</span><span class="s3">/</span><span class="s6">2</span><span class="s3">, </span><span class="s1">ys </span><span class="s3">- </span><span class="s1">hs</span><span class="s3">/</span><span class="s6">2</span><span class="s3">, </span><span class="s1">ws</span><span class="s3">, </span><span class="s1">hs</span><span class="s3">));</span>
        <span class="s1">draw</span><span class="s3">();</span>
    <span class="s3">}</span>


    <span class="s0">/**</span>
     <span class="s0">* Draws a circular arc of the specified radius,</span>
     <span class="s0">* centered at (</span><span class="s5">&lt;em&gt;</span><span class="s0">x</span><span class="s5">&lt;/em&gt;</span><span class="s0">, </span><span class="s5">&lt;em&gt;</span><span class="s0">y</span><span class="s5">&lt;/em&gt;</span><span class="s0">), from angle1 to angle2 (in degrees).</span>
     <span class="s0">*</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">x the </span><span class="s5">&lt;em&gt;</span><span class="s0">x</span><span class="s5">&lt;/em&gt;</span><span class="s0">-coordinate of the center of the circle</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">y the </span><span class="s5">&lt;em&gt;</span><span class="s0">y</span><span class="s5">&lt;/em&gt;</span><span class="s0">-coordinate of the center of the circle</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">radius the radius of the circle</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">angle1 the starting angle. 0 would mean an arc beginning at 3 o'clock.</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">angle2 the angle at the end of the arc. For example, if</span>
     <span class="s0">*         you want a 90 degree arc, then angle2 should be angle1 + 90.</span>
     <span class="s0">* </span><span class="s4">@throws </span><span class="s0">IllegalArgumentException if {</span><span class="s4">@code </span><span class="s0">radius} is negative</span>
     <span class="s0">* </span><span class="s4">@throws </span><span class="s0">IllegalArgumentException if any argument is either NaN or infinite</span>
     <span class="s0">*/</span>
    <span class="s2">public static void </span><span class="s1">arc</span><span class="s3">(</span><span class="s2">double </span><span class="s1">x</span><span class="s3">, </span><span class="s2">double </span><span class="s1">y</span><span class="s3">, </span><span class="s2">double </span><span class="s1">radius</span><span class="s3">, </span><span class="s2">double </span><span class="s1">angle1</span><span class="s3">, </span><span class="s2">double </span><span class="s1">angle2</span><span class="s3">) {</span>
        <span class="s1">validate</span><span class="s3">(</span><span class="s1">x</span><span class="s3">, </span><span class="s8">&quot;x&quot;</span><span class="s3">);</span>
        <span class="s1">validate</span><span class="s3">(</span><span class="s1">y</span><span class="s3">, </span><span class="s8">&quot;y&quot;</span><span class="s3">);</span>
        <span class="s1">validate</span><span class="s3">(</span><span class="s1">radius</span><span class="s3">, </span><span class="s8">&quot;arc radius&quot;</span><span class="s3">);</span>
        <span class="s1">validate</span><span class="s3">(</span><span class="s1">angle1</span><span class="s3">, </span><span class="s8">&quot;angle1&quot;</span><span class="s3">);</span>
        <span class="s1">validate</span><span class="s3">(</span><span class="s1">angle2</span><span class="s3">, </span><span class="s8">&quot;angle2&quot;</span><span class="s3">);</span>
        <span class="s1">validateNonnegative</span><span class="s3">(</span><span class="s1">radius</span><span class="s3">, </span><span class="s8">&quot;arc radius&quot;</span><span class="s3">);</span>

        <span class="s2">while </span><span class="s3">(</span><span class="s1">angle2 </span><span class="s3">&lt; </span><span class="s1">angle1</span><span class="s3">) </span><span class="s1">angle2 </span><span class="s3">+= </span><span class="s6">360</span><span class="s3">;</span>
        <span class="s2">double </span><span class="s1">xs </span><span class="s3">= </span><span class="s1">scaleX</span><span class="s3">(</span><span class="s1">x</span><span class="s3">);</span>
        <span class="s2">double </span><span class="s1">ys </span><span class="s3">= </span><span class="s1">scaleY</span><span class="s3">(</span><span class="s1">y</span><span class="s3">);</span>
        <span class="s2">double </span><span class="s1">ws </span><span class="s3">= </span><span class="s1">factorX</span><span class="s3">(</span><span class="s6">2</span><span class="s3">*</span><span class="s1">radius</span><span class="s3">);</span>
        <span class="s2">double </span><span class="s1">hs </span><span class="s3">= </span><span class="s1">factorY</span><span class="s3">(</span><span class="s6">2</span><span class="s3">*</span><span class="s1">radius</span><span class="s3">);</span>
        <span class="s2">if </span><span class="s3">(</span><span class="s1">ws </span><span class="s3">&lt;= </span><span class="s6">1 </span><span class="s3">&amp;&amp; </span><span class="s1">hs </span><span class="s3">&lt;= </span><span class="s6">1</span><span class="s3">) </span><span class="s1">pixel</span><span class="s3">(</span><span class="s1">x</span><span class="s3">, </span><span class="s1">y</span><span class="s3">);</span>
        <span class="s2">else </span><span class="s1">offscreen</span><span class="s3">.</span><span class="s1">draw</span><span class="s3">(</span><span class="s2">new </span><span class="s1">Arc2D</span><span class="s3">.</span><span class="s1">Double</span><span class="s3">(</span><span class="s1">xs </span><span class="s3">- </span><span class="s1">ws</span><span class="s3">/</span><span class="s6">2</span><span class="s3">, </span><span class="s1">ys </span><span class="s3">- </span><span class="s1">hs</span><span class="s3">/</span><span class="s6">2</span><span class="s3">, </span><span class="s1">ws</span><span class="s3">, </span><span class="s1">hs</span><span class="s3">, </span><span class="s1">angle1</span><span class="s3">, </span><span class="s1">angle2 </span><span class="s3">- </span><span class="s1">angle1</span><span class="s3">, </span><span class="s1">Arc2D</span><span class="s3">.</span><span class="s1">OPEN</span><span class="s3">));</span>
        <span class="s1">draw</span><span class="s3">();</span>
    <span class="s3">}</span>

    <span class="s0">/**</span>
     <span class="s0">* Draws a square of the specified size, centered at (</span><span class="s5">&lt;em&gt;</span><span class="s0">x</span><span class="s5">&lt;/em&gt;</span><span class="s0">, </span><span class="s5">&lt;em&gt;</span><span class="s0">y</span><span class="s5">&lt;/em&gt;</span><span class="s0">).</span>
     <span class="s0">*</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">x the </span><span class="s5">&lt;em&gt;</span><span class="s0">x</span><span class="s5">&lt;/em&gt;</span><span class="s0">-coordinate of the center of the square</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">y the </span><span class="s5">&lt;em&gt;</span><span class="s0">y</span><span class="s5">&lt;/em&gt;</span><span class="s0">-coordinate of the center of the square</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">halfLength one half the length of any side of the square</span>
     <span class="s0">* </span><span class="s4">@throws </span><span class="s0">IllegalArgumentException if {</span><span class="s4">@code </span><span class="s0">halfLength} is negative</span>
     <span class="s0">* </span><span class="s4">@throws </span><span class="s0">IllegalArgumentException if any argument is either NaN or infinite</span>
     <span class="s0">*/</span>
    <span class="s2">public static void </span><span class="s1">square</span><span class="s3">(</span><span class="s2">double </span><span class="s1">x</span><span class="s3">, </span><span class="s2">double </span><span class="s1">y</span><span class="s3">, </span><span class="s2">double </span><span class="s1">halfLength</span><span class="s3">) {</span>
        <span class="s1">validate</span><span class="s3">(</span><span class="s1">x</span><span class="s3">, </span><span class="s8">&quot;x&quot;</span><span class="s3">);</span>
        <span class="s1">validate</span><span class="s3">(</span><span class="s1">y</span><span class="s3">, </span><span class="s8">&quot;y&quot;</span><span class="s3">);</span>
        <span class="s1">validate</span><span class="s3">(</span><span class="s1">halfLength</span><span class="s3">, </span><span class="s8">&quot;halfLength&quot;</span><span class="s3">);</span>
        <span class="s1">validateNonnegative</span><span class="s3">(</span><span class="s1">halfLength</span><span class="s3">, </span><span class="s8">&quot;half length&quot;</span><span class="s3">);</span>

        <span class="s2">double </span><span class="s1">xs </span><span class="s3">= </span><span class="s1">scaleX</span><span class="s3">(</span><span class="s1">x</span><span class="s3">);</span>
        <span class="s2">double </span><span class="s1">ys </span><span class="s3">= </span><span class="s1">scaleY</span><span class="s3">(</span><span class="s1">y</span><span class="s3">);</span>
        <span class="s2">double </span><span class="s1">ws </span><span class="s3">= </span><span class="s1">factorX</span><span class="s3">(</span><span class="s6">2</span><span class="s3">*</span><span class="s1">halfLength</span><span class="s3">);</span>
        <span class="s2">double </span><span class="s1">hs </span><span class="s3">= </span><span class="s1">factorY</span><span class="s3">(</span><span class="s6">2</span><span class="s3">*</span><span class="s1">halfLength</span><span class="s3">);</span>
        <span class="s2">if </span><span class="s3">(</span><span class="s1">ws </span><span class="s3">&lt;= </span><span class="s6">1 </span><span class="s3">&amp;&amp; </span><span class="s1">hs </span><span class="s3">&lt;= </span><span class="s6">1</span><span class="s3">) </span><span class="s1">pixel</span><span class="s3">(</span><span class="s1">x</span><span class="s3">, </span><span class="s1">y</span><span class="s3">);</span>
        <span class="s2">else </span><span class="s1">offscreen</span><span class="s3">.</span><span class="s1">draw</span><span class="s3">(</span><span class="s2">new </span><span class="s1">Rectangle2D</span><span class="s3">.</span><span class="s1">Double</span><span class="s3">(</span><span class="s1">xs </span><span class="s3">- </span><span class="s1">ws</span><span class="s3">/</span><span class="s6">2</span><span class="s3">, </span><span class="s1">ys </span><span class="s3">- </span><span class="s1">hs</span><span class="s3">/</span><span class="s6">2</span><span class="s3">, </span><span class="s1">ws</span><span class="s3">, </span><span class="s1">hs</span><span class="s3">));</span>
        <span class="s1">draw</span><span class="s3">();</span>
    <span class="s3">}</span>

    <span class="s0">/**</span>
     <span class="s0">* Draws a filled square of the specified size, centered at (</span><span class="s5">&lt;em&gt;</span><span class="s0">x</span><span class="s5">&lt;/em&gt;</span><span class="s0">, </span><span class="s5">&lt;em&gt;</span><span class="s0">y</span><span class="s5">&lt;/em&gt;</span><span class="s0">).</span>
     <span class="s0">*</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">x the </span><span class="s5">&lt;em&gt;</span><span class="s0">x</span><span class="s5">&lt;/em&gt;</span><span class="s0">-coordinate of the center of the square</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">y the </span><span class="s5">&lt;em&gt;</span><span class="s0">y</span><span class="s5">&lt;/em&gt;</span><span class="s0">-coordinate of the center of the square</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">halfLength one half the length of any side of the square</span>
     <span class="s0">* </span><span class="s4">@throws </span><span class="s0">IllegalArgumentException if {</span><span class="s4">@code </span><span class="s0">halfLength} is negative</span>
     <span class="s0">* </span><span class="s4">@throws </span><span class="s0">IllegalArgumentException if any argument is either NaN or infinite</span>
     <span class="s0">*/</span>
    <span class="s2">public static void </span><span class="s1">filledSquare</span><span class="s3">(</span><span class="s2">double </span><span class="s1">x</span><span class="s3">, </span><span class="s2">double </span><span class="s1">y</span><span class="s3">, </span><span class="s2">double </span><span class="s1">halfLength</span><span class="s3">) {</span>
        <span class="s1">validate</span><span class="s3">(</span><span class="s1">x</span><span class="s3">, </span><span class="s8">&quot;x&quot;</span><span class="s3">);</span>
        <span class="s1">validate</span><span class="s3">(</span><span class="s1">y</span><span class="s3">, </span><span class="s8">&quot;y&quot;</span><span class="s3">);</span>
        <span class="s1">validate</span><span class="s3">(</span><span class="s1">halfLength</span><span class="s3">, </span><span class="s8">&quot;halfLength&quot;</span><span class="s3">);</span>
        <span class="s1">validateNonnegative</span><span class="s3">(</span><span class="s1">halfLength</span><span class="s3">, </span><span class="s8">&quot;half length&quot;</span><span class="s3">);</span>

        <span class="s2">double </span><span class="s1">xs </span><span class="s3">= </span><span class="s1">scaleX</span><span class="s3">(</span><span class="s1">x</span><span class="s3">);</span>
        <span class="s2">double </span><span class="s1">ys </span><span class="s3">= </span><span class="s1">scaleY</span><span class="s3">(</span><span class="s1">y</span><span class="s3">);</span>
        <span class="s2">double </span><span class="s1">ws </span><span class="s3">= </span><span class="s1">factorX</span><span class="s3">(</span><span class="s6">2</span><span class="s3">*</span><span class="s1">halfLength</span><span class="s3">);</span>
        <span class="s2">double </span><span class="s1">hs </span><span class="s3">= </span><span class="s1">factorY</span><span class="s3">(</span><span class="s6">2</span><span class="s3">*</span><span class="s1">halfLength</span><span class="s3">);</span>
        <span class="s2">if </span><span class="s3">(</span><span class="s1">ws </span><span class="s3">&lt;= </span><span class="s6">1 </span><span class="s3">&amp;&amp; </span><span class="s1">hs </span><span class="s3">&lt;= </span><span class="s6">1</span><span class="s3">) </span><span class="s1">pixel</span><span class="s3">(</span><span class="s1">x</span><span class="s3">, </span><span class="s1">y</span><span class="s3">);</span>
        <span class="s2">else </span><span class="s1">offscreen</span><span class="s3">.</span><span class="s1">fill</span><span class="s3">(</span><span class="s2">new </span><span class="s1">Rectangle2D</span><span class="s3">.</span><span class="s1">Double</span><span class="s3">(</span><span class="s1">xs </span><span class="s3">- </span><span class="s1">ws</span><span class="s3">/</span><span class="s6">2</span><span class="s3">, </span><span class="s1">ys </span><span class="s3">- </span><span class="s1">hs</span><span class="s3">/</span><span class="s6">2</span><span class="s3">, </span><span class="s1">ws</span><span class="s3">, </span><span class="s1">hs</span><span class="s3">));</span>
        <span class="s1">draw</span><span class="s3">();</span>
    <span class="s3">}</span>


    <span class="s0">/**</span>
     <span class="s0">* Draws a rectangle of the specified size, centered at (</span><span class="s5">&lt;em&gt;</span><span class="s0">x</span><span class="s5">&lt;/em&gt;</span><span class="s0">, </span><span class="s5">&lt;em&gt;</span><span class="s0">y</span><span class="s5">&lt;/em&gt;</span><span class="s0">).</span>
     <span class="s0">*</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">x the </span><span class="s5">&lt;em&gt;</span><span class="s0">x</span><span class="s5">&lt;/em&gt;</span><span class="s0">-coordinate of the center of the rectangle</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">y the </span><span class="s5">&lt;em&gt;</span><span class="s0">y</span><span class="s5">&lt;/em&gt;</span><span class="s0">-coordinate of the center of the rectangle</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">halfWidth one half the width of the rectangle</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">halfHeight one half the height of the rectangle</span>
     <span class="s0">* </span><span class="s4">@throws </span><span class="s0">IllegalArgumentException if either {</span><span class="s4">@code </span><span class="s0">halfWidth} or {</span><span class="s4">@code </span><span class="s0">halfHeight} is negative</span>
     <span class="s0">* </span><span class="s4">@throws </span><span class="s0">IllegalArgumentException if any argument is either NaN or infinite</span>
     <span class="s0">*/</span>
    <span class="s2">public static void </span><span class="s1">rectangle</span><span class="s3">(</span><span class="s2">double </span><span class="s1">x</span><span class="s3">, </span><span class="s2">double </span><span class="s1">y</span><span class="s3">, </span><span class="s2">double </span><span class="s1">halfWidth</span><span class="s3">, </span><span class="s2">double </span><span class="s1">halfHeight</span><span class="s3">) {</span>
        <span class="s1">validate</span><span class="s3">(</span><span class="s1">x</span><span class="s3">, </span><span class="s8">&quot;x&quot;</span><span class="s3">);</span>
        <span class="s1">validate</span><span class="s3">(</span><span class="s1">y</span><span class="s3">, </span><span class="s8">&quot;y&quot;</span><span class="s3">);</span>
        <span class="s1">validate</span><span class="s3">(</span><span class="s1">halfWidth</span><span class="s3">, </span><span class="s8">&quot;halfWidth&quot;</span><span class="s3">);</span>
        <span class="s1">validate</span><span class="s3">(</span><span class="s1">halfHeight</span><span class="s3">, </span><span class="s8">&quot;halfHeight&quot;</span><span class="s3">);</span>
        <span class="s1">validateNonnegative</span><span class="s3">(</span><span class="s1">halfWidth</span><span class="s3">, </span><span class="s8">&quot;half width&quot;</span><span class="s3">);</span>
        <span class="s1">validateNonnegative</span><span class="s3">(</span><span class="s1">halfHeight</span><span class="s3">, </span><span class="s8">&quot;half height&quot;</span><span class="s3">);</span>

        <span class="s2">double </span><span class="s1">xs </span><span class="s3">= </span><span class="s1">scaleX</span><span class="s3">(</span><span class="s1">x</span><span class="s3">);</span>
        <span class="s2">double </span><span class="s1">ys </span><span class="s3">= </span><span class="s1">scaleY</span><span class="s3">(</span><span class="s1">y</span><span class="s3">);</span>
        <span class="s2">double </span><span class="s1">ws </span><span class="s3">= </span><span class="s1">factorX</span><span class="s3">(</span><span class="s6">2</span><span class="s3">*</span><span class="s1">halfWidth</span><span class="s3">);</span>
        <span class="s2">double </span><span class="s1">hs </span><span class="s3">= </span><span class="s1">factorY</span><span class="s3">(</span><span class="s6">2</span><span class="s3">*</span><span class="s1">halfHeight</span><span class="s3">);</span>
        <span class="s2">if </span><span class="s3">(</span><span class="s1">ws </span><span class="s3">&lt;= </span><span class="s6">1 </span><span class="s3">&amp;&amp; </span><span class="s1">hs </span><span class="s3">&lt;= </span><span class="s6">1</span><span class="s3">) </span><span class="s1">pixel</span><span class="s3">(</span><span class="s1">x</span><span class="s3">, </span><span class="s1">y</span><span class="s3">);</span>
        <span class="s2">else </span><span class="s1">offscreen</span><span class="s3">.</span><span class="s1">draw</span><span class="s3">(</span><span class="s2">new </span><span class="s1">Rectangle2D</span><span class="s3">.</span><span class="s1">Double</span><span class="s3">(</span><span class="s1">xs </span><span class="s3">- </span><span class="s1">ws</span><span class="s3">/</span><span class="s6">2</span><span class="s3">, </span><span class="s1">ys </span><span class="s3">- </span><span class="s1">hs</span><span class="s3">/</span><span class="s6">2</span><span class="s3">, </span><span class="s1">ws</span><span class="s3">, </span><span class="s1">hs</span><span class="s3">));</span>
        <span class="s1">draw</span><span class="s3">();</span>
    <span class="s3">}</span>

    <span class="s0">/**</span>
     <span class="s0">* Draws a filled rectangle of the specified size, centered at (</span><span class="s5">&lt;em&gt;</span><span class="s0">x</span><span class="s5">&lt;/em&gt;</span><span class="s0">, </span><span class="s5">&lt;em&gt;</span><span class="s0">y</span><span class="s5">&lt;/em&gt;</span><span class="s0">).</span>
     <span class="s0">*</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">x the </span><span class="s5">&lt;em&gt;</span><span class="s0">x</span><span class="s5">&lt;/em&gt;</span><span class="s0">-coordinate of the center of the rectangle</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">y the </span><span class="s5">&lt;em&gt;</span><span class="s0">y</span><span class="s5">&lt;/em&gt;</span><span class="s0">-coordinate of the center of the rectangle</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">halfWidth one half the width of the rectangle</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">halfHeight one half the height of the rectangle</span>
     <span class="s0">* </span><span class="s4">@throws </span><span class="s0">IllegalArgumentException if either {</span><span class="s4">@code </span><span class="s0">halfWidth} or {</span><span class="s4">@code </span><span class="s0">halfHeight} is negative</span>
     <span class="s0">* </span><span class="s4">@throws </span><span class="s0">IllegalArgumentException if any argument is either NaN or infinite</span>
     <span class="s0">*/</span>
    <span class="s2">public static void </span><span class="s1">filledRectangle</span><span class="s3">(</span><span class="s2">double </span><span class="s1">x</span><span class="s3">, </span><span class="s2">double </span><span class="s1">y</span><span class="s3">, </span><span class="s2">double </span><span class="s1">halfWidth</span><span class="s3">, </span><span class="s2">double </span><span class="s1">halfHeight</span><span class="s3">) {</span>
        <span class="s1">validate</span><span class="s3">(</span><span class="s1">x</span><span class="s3">, </span><span class="s8">&quot;x&quot;</span><span class="s3">);</span>
        <span class="s1">validate</span><span class="s3">(</span><span class="s1">y</span><span class="s3">, </span><span class="s8">&quot;y&quot;</span><span class="s3">);</span>
        <span class="s1">validate</span><span class="s3">(</span><span class="s1">halfWidth</span><span class="s3">, </span><span class="s8">&quot;halfWidth&quot;</span><span class="s3">);</span>
        <span class="s1">validate</span><span class="s3">(</span><span class="s1">halfHeight</span><span class="s3">, </span><span class="s8">&quot;halfHeight&quot;</span><span class="s3">);</span>
        <span class="s1">validateNonnegative</span><span class="s3">(</span><span class="s1">halfWidth</span><span class="s3">, </span><span class="s8">&quot;half width&quot;</span><span class="s3">);</span>
        <span class="s1">validateNonnegative</span><span class="s3">(</span><span class="s1">halfHeight</span><span class="s3">, </span><span class="s8">&quot;half height&quot;</span><span class="s3">);</span>

        <span class="s2">double </span><span class="s1">xs </span><span class="s3">= </span><span class="s1">scaleX</span><span class="s3">(</span><span class="s1">x</span><span class="s3">);</span>
        <span class="s2">double </span><span class="s1">ys </span><span class="s3">= </span><span class="s1">scaleY</span><span class="s3">(</span><span class="s1">y</span><span class="s3">);</span>
        <span class="s2">double </span><span class="s1">ws </span><span class="s3">= </span><span class="s1">factorX</span><span class="s3">(</span><span class="s6">2</span><span class="s3">*</span><span class="s1">halfWidth</span><span class="s3">);</span>
        <span class="s2">double </span><span class="s1">hs </span><span class="s3">= </span><span class="s1">factorY</span><span class="s3">(</span><span class="s6">2</span><span class="s3">*</span><span class="s1">halfHeight</span><span class="s3">);</span>
        <span class="s2">if </span><span class="s3">(</span><span class="s1">ws </span><span class="s3">&lt;= </span><span class="s6">1 </span><span class="s3">&amp;&amp; </span><span class="s1">hs </span><span class="s3">&lt;= </span><span class="s6">1</span><span class="s3">) </span><span class="s1">pixel</span><span class="s3">(</span><span class="s1">x</span><span class="s3">, </span><span class="s1">y</span><span class="s3">);</span>
        <span class="s2">else </span><span class="s1">offscreen</span><span class="s3">.</span><span class="s1">fill</span><span class="s3">(</span><span class="s2">new </span><span class="s1">Rectangle2D</span><span class="s3">.</span><span class="s1">Double</span><span class="s3">(</span><span class="s1">xs </span><span class="s3">- </span><span class="s1">ws</span><span class="s3">/</span><span class="s6">2</span><span class="s3">, </span><span class="s1">ys </span><span class="s3">- </span><span class="s1">hs</span><span class="s3">/</span><span class="s6">2</span><span class="s3">, </span><span class="s1">ws</span><span class="s3">, </span><span class="s1">hs</span><span class="s3">));</span>
        <span class="s1">draw</span><span class="s3">();</span>
    <span class="s3">}</span>


    <span class="s0">/**</span>
     <span class="s0">* Draws a polygon with the vertices</span>
     <span class="s0">* (</span><span class="s5">&lt;em&gt;</span><span class="s0">x</span><span class="s5">&lt;/em&gt;&lt;sub&gt;</span><span class="s0">0</span><span class="s5">&lt;/sub&gt;</span><span class="s0">, </span><span class="s5">&lt;em&gt;</span><span class="s0">y</span><span class="s5">&lt;/em&gt;&lt;sub&gt;</span><span class="s0">0</span><span class="s5">&lt;/sub&gt;</span><span class="s0">),</span>
     <span class="s0">* (</span><span class="s5">&lt;em&gt;</span><span class="s0">x</span><span class="s5">&lt;/em&gt;&lt;sub&gt;</span><span class="s0">1</span><span class="s5">&lt;/sub&gt;</span><span class="s0">, </span><span class="s5">&lt;em&gt;</span><span class="s0">y</span><span class="s5">&lt;/em&gt;&lt;sub&gt;</span><span class="s0">1</span><span class="s5">&lt;/sub&gt;</span><span class="s0">), ...,</span>
     <span class="s0">* (</span><span class="s5">&lt;em&gt;</span><span class="s0">x</span><span class="s5">&lt;/em&gt;&lt;sub&gt;&lt;em&gt;</span><span class="s0">n</span><span class="s5">&lt;/em&gt;</span><span class="s0">–1</span><span class="s5">&lt;/sub&gt;</span><span class="s0">, </span><span class="s5">&lt;em&gt;</span><span class="s0">y</span><span class="s5">&lt;/em&gt;&lt;sub&gt;&lt;em&gt;</span><span class="s0">n</span><span class="s5">&lt;/em&gt;</span><span class="s0">–1</span><span class="s5">&lt;/sub&gt;</span><span class="s0">).</span>
     <span class="s0">*</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">x an array of all the </span><span class="s5">&lt;em&gt;</span><span class="s0">x</span><span class="s5">&lt;/em&gt;</span><span class="s0">-coordinates of the polygon</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">y an array of all the </span><span class="s5">&lt;em&gt;</span><span class="s0">y</span><span class="s5">&lt;/em&gt;</span><span class="s0">-coordinates of the polygon</span>
     <span class="s0">* </span><span class="s4">@throws </span><span class="s0">IllegalArgumentException unless {</span><span class="s4">@code </span><span class="s0">x[]} and {</span><span class="s4">@code </span><span class="s0">y[]}</span>
     <span class="s0">*         are of the same length</span>
     <span class="s0">* </span><span class="s4">@throws </span><span class="s0">IllegalArgumentException if any coordinate is either NaN or infinite</span>
     <span class="s0">* </span><span class="s4">@throws </span><span class="s0">IllegalArgumentException if either {</span><span class="s4">@code </span><span class="s0">x[]} or {</span><span class="s4">@code </span><span class="s0">y[]} is {</span><span class="s4">@code </span><span class="s0">null}</span>
     <span class="s0">*/</span>
    <span class="s2">public static void </span><span class="s1">polygon</span><span class="s3">(</span><span class="s2">double</span><span class="s3">[] </span><span class="s1">x</span><span class="s3">, </span><span class="s2">double</span><span class="s3">[] </span><span class="s1">y</span><span class="s3">) {</span>
        <span class="s1">validateNotNull</span><span class="s3">(</span><span class="s1">x</span><span class="s3">, </span><span class="s8">&quot;x-coordinate array&quot;</span><span class="s3">);</span>
        <span class="s1">validateNotNull</span><span class="s3">(</span><span class="s1">y</span><span class="s3">, </span><span class="s8">&quot;y-coordinate array&quot;</span><span class="s3">);</span>
        <span class="s2">for </span><span class="s3">(</span><span class="s2">int </span><span class="s1">i </span><span class="s3">= </span><span class="s6">0</span><span class="s3">; </span><span class="s1">i </span><span class="s3">&lt; </span><span class="s1">x</span><span class="s3">.</span><span class="s1">length</span><span class="s3">; </span><span class="s1">i</span><span class="s3">++) </span><span class="s1">validate</span><span class="s3">(</span><span class="s1">x</span><span class="s3">[</span><span class="s1">i</span><span class="s3">], </span><span class="s8">&quot;x[&quot; </span><span class="s3">+ </span><span class="s1">i </span><span class="s3">+ </span><span class="s8">&quot;]&quot;</span><span class="s3">);</span>
        <span class="s2">for </span><span class="s3">(</span><span class="s2">int </span><span class="s1">i </span><span class="s3">= </span><span class="s6">0</span><span class="s3">; </span><span class="s1">i </span><span class="s3">&lt; </span><span class="s1">y</span><span class="s3">.</span><span class="s1">length</span><span class="s3">; </span><span class="s1">i</span><span class="s3">++) </span><span class="s1">validate</span><span class="s3">(</span><span class="s1">y</span><span class="s3">[</span><span class="s1">i</span><span class="s3">], </span><span class="s8">&quot;y[&quot; </span><span class="s3">+ </span><span class="s1">i </span><span class="s3">+ </span><span class="s8">&quot;]&quot;</span><span class="s3">);</span>

        <span class="s2">int </span><span class="s1">n1 </span><span class="s3">= </span><span class="s1">x</span><span class="s3">.</span><span class="s1">length</span><span class="s3">;</span>
        <span class="s2">int </span><span class="s1">n2 </span><span class="s3">= </span><span class="s1">y</span><span class="s3">.</span><span class="s1">length</span><span class="s3">;</span>
        <span class="s2">if </span><span class="s3">(</span><span class="s1">n1 </span><span class="s3">!= </span><span class="s1">n2</span><span class="s3">) </span><span class="s2">throw new </span><span class="s1">IllegalArgumentException</span><span class="s3">(</span><span class="s8">&quot;arrays must be of the same length&quot;</span><span class="s3">);</span>
        <span class="s2">int </span><span class="s1">n </span><span class="s3">= </span><span class="s1">n1</span><span class="s3">;</span>
        <span class="s2">if </span><span class="s3">(</span><span class="s1">n </span><span class="s3">== </span><span class="s6">0</span><span class="s3">) </span><span class="s2">return</span><span class="s3">;</span>

        <span class="s1">GeneralPath path </span><span class="s3">= </span><span class="s2">new </span><span class="s1">GeneralPath</span><span class="s3">();</span>
        <span class="s1">path</span><span class="s3">.</span><span class="s1">moveTo</span><span class="s3">((</span><span class="s2">float</span><span class="s3">) </span><span class="s1">scaleX</span><span class="s3">(</span><span class="s1">x</span><span class="s3">[</span><span class="s6">0</span><span class="s3">]), (</span><span class="s2">float</span><span class="s3">) </span><span class="s1">scaleY</span><span class="s3">(</span><span class="s1">y</span><span class="s3">[</span><span class="s6">0</span><span class="s3">]));</span>
        <span class="s2">for </span><span class="s3">(</span><span class="s2">int </span><span class="s1">i </span><span class="s3">= </span><span class="s6">0</span><span class="s3">; </span><span class="s1">i </span><span class="s3">&lt; </span><span class="s1">n</span><span class="s3">; </span><span class="s1">i</span><span class="s3">++)</span>
            <span class="s1">path</span><span class="s3">.</span><span class="s1">lineTo</span><span class="s3">((</span><span class="s2">float</span><span class="s3">) </span><span class="s1">scaleX</span><span class="s3">(</span><span class="s1">x</span><span class="s3">[</span><span class="s1">i</span><span class="s3">]), (</span><span class="s2">float</span><span class="s3">) </span><span class="s1">scaleY</span><span class="s3">(</span><span class="s1">y</span><span class="s3">[</span><span class="s1">i</span><span class="s3">]));</span>
        <span class="s1">path</span><span class="s3">.</span><span class="s1">closePath</span><span class="s3">();</span>
        <span class="s1">offscreen</span><span class="s3">.</span><span class="s1">draw</span><span class="s3">(</span><span class="s1">path</span><span class="s3">);</span>
        <span class="s1">draw</span><span class="s3">();</span>
    <span class="s3">}</span>

    <span class="s0">/**</span>
     <span class="s0">* Draws a filled polygon with the vertices</span>
     <span class="s0">* (</span><span class="s5">&lt;em&gt;</span><span class="s0">x</span><span class="s5">&lt;/em&gt;&lt;sub&gt;</span><span class="s0">0</span><span class="s5">&lt;/sub&gt;</span><span class="s0">, </span><span class="s5">&lt;em&gt;</span><span class="s0">y</span><span class="s5">&lt;/em&gt;&lt;sub&gt;</span><span class="s0">0</span><span class="s5">&lt;/sub&gt;</span><span class="s0">),</span>
     <span class="s0">* (</span><span class="s5">&lt;em&gt;</span><span class="s0">x</span><span class="s5">&lt;/em&gt;&lt;sub&gt;</span><span class="s0">1</span><span class="s5">&lt;/sub&gt;</span><span class="s0">, </span><span class="s5">&lt;em&gt;</span><span class="s0">y</span><span class="s5">&lt;/em&gt;&lt;sub&gt;</span><span class="s0">1</span><span class="s5">&lt;/sub&gt;</span><span class="s0">), ...,</span>
     <span class="s0">* (</span><span class="s5">&lt;em&gt;</span><span class="s0">x</span><span class="s5">&lt;/em&gt;&lt;sub&gt;&lt;em&gt;</span><span class="s0">n</span><span class="s5">&lt;/em&gt;</span><span class="s0">–1</span><span class="s5">&lt;/sub&gt;</span><span class="s0">, </span><span class="s5">&lt;em&gt;</span><span class="s0">y</span><span class="s5">&lt;/em&gt;&lt;sub&gt;&lt;em&gt;</span><span class="s0">n</span><span class="s5">&lt;/em&gt;</span><span class="s0">–1</span><span class="s5">&lt;/sub&gt;</span><span class="s0">).</span>
     <span class="s0">*</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">x an array of all the </span><span class="s5">&lt;em&gt;</span><span class="s0">x</span><span class="s5">&lt;/em&gt;</span><span class="s0">-coordinates of the polygon</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">y an array of all the </span><span class="s5">&lt;em&gt;</span><span class="s0">y</span><span class="s5">&lt;/em&gt;</span><span class="s0">-coordinates of the polygon</span>
     <span class="s0">* </span><span class="s4">@throws </span><span class="s0">IllegalArgumentException unless {</span><span class="s4">@code </span><span class="s0">x[]} and {</span><span class="s4">@code </span><span class="s0">y[]}</span>
     <span class="s0">*         are of the same length</span>
     <span class="s0">* </span><span class="s4">@throws </span><span class="s0">IllegalArgumentException if any coordinate is either NaN or infinite</span>
     <span class="s0">* </span><span class="s4">@throws </span><span class="s0">IllegalArgumentException if either {</span><span class="s4">@code </span><span class="s0">x[]} or {</span><span class="s4">@code </span><span class="s0">y[]} is {</span><span class="s4">@code </span><span class="s0">null}</span>
     <span class="s0">*/</span>
    <span class="s2">public static void </span><span class="s1">filledPolygon</span><span class="s3">(</span><span class="s2">double</span><span class="s3">[] </span><span class="s1">x</span><span class="s3">, </span><span class="s2">double</span><span class="s3">[] </span><span class="s1">y</span><span class="s3">) {</span>
        <span class="s1">validateNotNull</span><span class="s3">(</span><span class="s1">x</span><span class="s3">, </span><span class="s8">&quot;x-coordinate array&quot;</span><span class="s3">);</span>
        <span class="s1">validateNotNull</span><span class="s3">(</span><span class="s1">y</span><span class="s3">, </span><span class="s8">&quot;y-coordinate array&quot;</span><span class="s3">);</span>
        <span class="s2">for </span><span class="s3">(</span><span class="s2">int </span><span class="s1">i </span><span class="s3">= </span><span class="s6">0</span><span class="s3">; </span><span class="s1">i </span><span class="s3">&lt; </span><span class="s1">x</span><span class="s3">.</span><span class="s1">length</span><span class="s3">; </span><span class="s1">i</span><span class="s3">++) </span><span class="s1">validate</span><span class="s3">(</span><span class="s1">x</span><span class="s3">[</span><span class="s1">i</span><span class="s3">], </span><span class="s8">&quot;x[&quot; </span><span class="s3">+ </span><span class="s1">i </span><span class="s3">+ </span><span class="s8">&quot;]&quot;</span><span class="s3">);</span>
        <span class="s2">for </span><span class="s3">(</span><span class="s2">int </span><span class="s1">i </span><span class="s3">= </span><span class="s6">0</span><span class="s3">; </span><span class="s1">i </span><span class="s3">&lt; </span><span class="s1">y</span><span class="s3">.</span><span class="s1">length</span><span class="s3">; </span><span class="s1">i</span><span class="s3">++) </span><span class="s1">validate</span><span class="s3">(</span><span class="s1">y</span><span class="s3">[</span><span class="s1">i</span><span class="s3">], </span><span class="s8">&quot;y[&quot; </span><span class="s3">+ </span><span class="s1">i </span><span class="s3">+ </span><span class="s8">&quot;]&quot;</span><span class="s3">);</span>

        <span class="s2">int </span><span class="s1">n1 </span><span class="s3">= </span><span class="s1">x</span><span class="s3">.</span><span class="s1">length</span><span class="s3">;</span>
        <span class="s2">int </span><span class="s1">n2 </span><span class="s3">= </span><span class="s1">y</span><span class="s3">.</span><span class="s1">length</span><span class="s3">;</span>
        <span class="s2">if </span><span class="s3">(</span><span class="s1">n1 </span><span class="s3">!= </span><span class="s1">n2</span><span class="s3">) </span><span class="s2">throw new </span><span class="s1">IllegalArgumentException</span><span class="s3">(</span><span class="s8">&quot;arrays must be of the same length&quot;</span><span class="s3">);</span>
        <span class="s2">int </span><span class="s1">n </span><span class="s3">= </span><span class="s1">n1</span><span class="s3">;</span>
        <span class="s2">if </span><span class="s3">(</span><span class="s1">n </span><span class="s3">== </span><span class="s6">0</span><span class="s3">) </span><span class="s2">return</span><span class="s3">;</span>

        <span class="s1">GeneralPath path </span><span class="s3">= </span><span class="s2">new </span><span class="s1">GeneralPath</span><span class="s3">();</span>
        <span class="s1">path</span><span class="s3">.</span><span class="s1">moveTo</span><span class="s3">((</span><span class="s2">float</span><span class="s3">) </span><span class="s1">scaleX</span><span class="s3">(</span><span class="s1">x</span><span class="s3">[</span><span class="s6">0</span><span class="s3">]), (</span><span class="s2">float</span><span class="s3">) </span><span class="s1">scaleY</span><span class="s3">(</span><span class="s1">y</span><span class="s3">[</span><span class="s6">0</span><span class="s3">]));</span>
        <span class="s2">for </span><span class="s3">(</span><span class="s2">int </span><span class="s1">i </span><span class="s3">= </span><span class="s6">0</span><span class="s3">; </span><span class="s1">i </span><span class="s3">&lt; </span><span class="s1">n</span><span class="s3">; </span><span class="s1">i</span><span class="s3">++)</span>
            <span class="s1">path</span><span class="s3">.</span><span class="s1">lineTo</span><span class="s3">((</span><span class="s2">float</span><span class="s3">) </span><span class="s1">scaleX</span><span class="s3">(</span><span class="s1">x</span><span class="s3">[</span><span class="s1">i</span><span class="s3">]), (</span><span class="s2">float</span><span class="s3">) </span><span class="s1">scaleY</span><span class="s3">(</span><span class="s1">y</span><span class="s3">[</span><span class="s1">i</span><span class="s3">]));</span>
        <span class="s1">path</span><span class="s3">.</span><span class="s1">closePath</span><span class="s3">();</span>
        <span class="s1">offscreen</span><span class="s3">.</span><span class="s1">fill</span><span class="s3">(</span><span class="s1">path</span><span class="s3">);</span>
        <span class="s1">draw</span><span class="s3">();</span>
    <span class="s3">}</span>


    <span class="s0">/***************************************************************************</span>
     <span class="s0">*  Drawing images.</span>
     <span class="s0">***************************************************************************/</span>
    <span class="s7">// get an image from the given filename</span>
    <span class="s2">private static </span><span class="s1">Image getImage</span><span class="s3">(</span><span class="s1">String filename</span><span class="s3">) {</span>
        <span class="s2">if </span><span class="s3">(</span><span class="s1">filename </span><span class="s3">== </span><span class="s2">null</span><span class="s3">) </span><span class="s2">throw new </span><span class="s1">IllegalArgumentException</span><span class="s3">();</span>

        <span class="s7">// to read from file</span>
        <span class="s1">ImageIcon icon </span><span class="s3">= </span><span class="s2">new </span><span class="s1">ImageIcon</span><span class="s3">(</span><span class="s1">filename</span><span class="s3">);</span>

        <span class="s7">// try to read from URL</span>
        <span class="s2">if </span><span class="s3">((</span><span class="s1">icon </span><span class="s3">== </span><span class="s2">null</span><span class="s3">) || (</span><span class="s1">icon</span><span class="s3">.</span><span class="s1">getImageLoadStatus</span><span class="s3">() != </span><span class="s1">MediaTracker</span><span class="s3">.</span><span class="s1">COMPLETE</span><span class="s3">)) {</span>
            <span class="s2">try </span><span class="s3">{</span>
                <span class="s1">URL url </span><span class="s3">= </span><span class="s2">new </span><span class="s1">URL</span><span class="s3">(</span><span class="s1">filename</span><span class="s3">);</span>
                <span class="s1">icon </span><span class="s3">= </span><span class="s2">new </span><span class="s1">ImageIcon</span><span class="s3">(</span><span class="s1">url</span><span class="s3">);</span>
            <span class="s3">}</span>
            <span class="s2">catch </span><span class="s3">(</span><span class="s1">MalformedURLException e</span><span class="s3">) {</span>
                <span class="s7">/* not a url */</span>
            <span class="s3">}</span>
        <span class="s3">}</span>

        <span class="s7">// in case file is inside a .jar (classpath relative to StdDraw)</span>
        <span class="s2">if </span><span class="s3">((</span><span class="s1">icon </span><span class="s3">== </span><span class="s2">null</span><span class="s3">) || (</span><span class="s1">icon</span><span class="s3">.</span><span class="s1">getImageLoadStatus</span><span class="s3">() != </span><span class="s1">MediaTracker</span><span class="s3">.</span><span class="s1">COMPLETE</span><span class="s3">)) {</span>
            <span class="s1">URL url </span><span class="s3">= </span><span class="s1">StdDraw</span><span class="s3">.</span><span class="s2">class</span><span class="s3">.</span><span class="s1">getResource</span><span class="s3">(</span><span class="s1">filename</span><span class="s3">);</span>
            <span class="s2">if </span><span class="s3">(</span><span class="s1">url </span><span class="s3">!= </span><span class="s2">null</span><span class="s3">)</span>
                <span class="s1">icon </span><span class="s3">= </span><span class="s2">new </span><span class="s1">ImageIcon</span><span class="s3">(</span><span class="s1">url</span><span class="s3">);</span>
        <span class="s3">}</span>

        <span class="s7">// in case file is inside a .jar (classpath relative to root of jar)</span>
        <span class="s2">if </span><span class="s3">((</span><span class="s1">icon </span><span class="s3">== </span><span class="s2">null</span><span class="s3">) || (</span><span class="s1">icon</span><span class="s3">.</span><span class="s1">getImageLoadStatus</span><span class="s3">() != </span><span class="s1">MediaTracker</span><span class="s3">.</span><span class="s1">COMPLETE</span><span class="s3">)) {</span>
            <span class="s1">URL url </span><span class="s3">= </span><span class="s1">StdDraw</span><span class="s3">.</span><span class="s2">class</span><span class="s3">.</span><span class="s1">getResource</span><span class="s3">(</span><span class="s8">&quot;/&quot; </span><span class="s3">+ </span><span class="s1">filename</span><span class="s3">);</span>
            <span class="s2">if </span><span class="s3">(</span><span class="s1">url </span><span class="s3">== </span><span class="s2">null</span><span class="s3">) </span><span class="s2">throw new </span><span class="s1">IllegalArgumentException</span><span class="s3">(</span><span class="s8">&quot;image &quot; </span><span class="s3">+ </span><span class="s1">filename </span><span class="s3">+ </span><span class="s8">&quot; not found&quot;</span><span class="s3">);</span>
            <span class="s1">icon </span><span class="s3">= </span><span class="s2">new </span><span class="s1">ImageIcon</span><span class="s3">(</span><span class="s1">url</span><span class="s3">);</span>
        <span class="s3">}</span>

        <span class="s2">return </span><span class="s1">icon</span><span class="s3">.</span><span class="s1">getImage</span><span class="s3">();</span>
    <span class="s3">}</span>

    <span class="s0">/***************************************************************************</span>
     <span class="s0">* [Summer 2016] Should we update to use ImageIO instead of ImageIcon()?</span>
     <span class="s0">*               Seems to have some issues loading images on some systems</span>
     <span class="s0">*               and slows things down on other systems.</span>
     <span class="s0">*               especially if you don't call ImageIO.setUseCache(false)</span>
     <span class="s0">*               One advantage is that it returns a BufferedImage.</span>
     <span class="s0">***************************************************************************/</span>
<span class="s7">/* 
    private static BufferedImage getImage(String filename) { 
        if (filename == null) throw new IllegalArgumentException(); 
 
        // from a file or URL 
        try { 
            URL url = new URL(filename); 
            BufferedImage image = ImageIO.read(url); 
            return image; 
        } 
        catch (IOException e) { 
            // ignore 
        } 
 
        // in case file is inside a .jar (classpath relative to StdDraw) 
        try { 
            URL url = StdDraw.class.getResource(filename); 
            BufferedImage image = ImageIO.read(url); 
            return image; 
        } 
        catch (IOException e) { 
            // ignore 
        } 
 
        // in case file is inside a .jar (classpath relative to root of jar) 
        try { 
            URL url = StdDraw.class.getResource(&quot;/&quot; + filename); 
            BufferedImage image = ImageIO.read(url); 
            return image; 
        } 
        catch (IOException e) { 
            // ignore 
        } 
        throw new IllegalArgumentException(&quot;image &quot; + filename + &quot; not found&quot;); 
    } 
*/</span>
    <span class="s0">/**</span>
     <span class="s0">* Draws the specified image centered at (</span><span class="s5">&lt;em&gt;</span><span class="s0">x</span><span class="s5">&lt;/em&gt;</span><span class="s0">, </span><span class="s5">&lt;em&gt;</span><span class="s0">y</span><span class="s5">&lt;/em&gt;</span><span class="s0">).</span>
     <span class="s0">* The supported image formats are JPEG, PNG, and GIF.</span>
     <span class="s0">* As an optimization, the picture is cached, so there is no performance</span>
     <span class="s0">* penalty for redrawing the same image multiple times (e.g., in an animation).</span>
     <span class="s0">* However, if you change the picture file after drawing it, subsequent</span>
     <span class="s0">* calls will draw the original picture.</span>
     <span class="s0">*</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">x the center </span><span class="s5">&lt;em&gt;</span><span class="s0">x</span><span class="s5">&lt;/em&gt;</span><span class="s0">-coordinate of the image</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">y the center </span><span class="s5">&lt;em&gt;</span><span class="s0">y</span><span class="s5">&lt;/em&gt;</span><span class="s0">-coordinate of the image</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">filename the name of the image/picture, e.g., &quot;ball.gif&quot;</span>
     <span class="s0">* </span><span class="s4">@throws </span><span class="s0">IllegalArgumentException if the image filename is invalid</span>
     <span class="s0">* </span><span class="s4">@throws </span><span class="s0">IllegalArgumentException if either {</span><span class="s4">@code </span><span class="s0">x} or {</span><span class="s4">@code </span><span class="s0">y} is either NaN or infinite</span>
     <span class="s0">*/</span>
    <span class="s2">public static void </span><span class="s1">picture</span><span class="s3">(</span><span class="s2">double </span><span class="s1">x</span><span class="s3">, </span><span class="s2">double </span><span class="s1">y</span><span class="s3">, </span><span class="s1">String filename</span><span class="s3">) {</span>
        <span class="s1">validate</span><span class="s3">(</span><span class="s1">x</span><span class="s3">, </span><span class="s8">&quot;x&quot;</span><span class="s3">);</span>
        <span class="s1">validate</span><span class="s3">(</span><span class="s1">y</span><span class="s3">, </span><span class="s8">&quot;y&quot;</span><span class="s3">);</span>
        <span class="s1">validateNotNull</span><span class="s3">(</span><span class="s1">filename</span><span class="s3">, </span><span class="s8">&quot;filename&quot;</span><span class="s3">);</span>

        <span class="s7">// BufferedImage image = getImage(filename);</span>
        <span class="s1">Image image </span><span class="s3">= </span><span class="s1">getImage</span><span class="s3">(</span><span class="s1">filename</span><span class="s3">);</span>
        <span class="s2">double </span><span class="s1">xs </span><span class="s3">= </span><span class="s1">scaleX</span><span class="s3">(</span><span class="s1">x</span><span class="s3">);</span>
        <span class="s2">double </span><span class="s1">ys </span><span class="s3">= </span><span class="s1">scaleY</span><span class="s3">(</span><span class="s1">y</span><span class="s3">);</span>
        <span class="s7">// int ws = image.getWidth();    // can call only if image is a BufferedImage</span>
        <span class="s7">// int hs = image.getHeight();</span>
        <span class="s2">int </span><span class="s1">ws </span><span class="s3">= </span><span class="s1">image</span><span class="s3">.</span><span class="s1">getWidth</span><span class="s3">(</span><span class="s2">null</span><span class="s3">);</span>
        <span class="s2">int </span><span class="s1">hs </span><span class="s3">= </span><span class="s1">image</span><span class="s3">.</span><span class="s1">getHeight</span><span class="s3">(</span><span class="s2">null</span><span class="s3">);</span>
        <span class="s2">if </span><span class="s3">(</span><span class="s1">ws </span><span class="s3">&lt; </span><span class="s6">0 </span><span class="s3">|| </span><span class="s1">hs </span><span class="s3">&lt; </span><span class="s6">0</span><span class="s3">) </span><span class="s2">throw new </span><span class="s1">IllegalArgumentException</span><span class="s3">(</span><span class="s8">&quot;image &quot; </span><span class="s3">+ </span><span class="s1">filename </span><span class="s3">+ </span><span class="s8">&quot; is corrupt&quot;</span><span class="s3">);</span>

        <span class="s1">offscreen</span><span class="s3">.</span><span class="s1">drawImage</span><span class="s3">(</span><span class="s1">image</span><span class="s3">, (</span><span class="s2">int</span><span class="s3">) </span><span class="s1">Math</span><span class="s3">.</span><span class="s1">round</span><span class="s3">(</span><span class="s1">xs </span><span class="s3">- </span><span class="s1">ws</span><span class="s3">/</span><span class="s6">2.0</span><span class="s3">), (</span><span class="s2">int</span><span class="s3">) </span><span class="s1">Math</span><span class="s3">.</span><span class="s1">round</span><span class="s3">(</span><span class="s1">ys </span><span class="s3">- </span><span class="s1">hs</span><span class="s3">/</span><span class="s6">2.0</span><span class="s3">), </span><span class="s2">null</span><span class="s3">);</span>
        <span class="s1">draw</span><span class="s3">();</span>
    <span class="s3">}</span>

    <span class="s0">/**</span>
     <span class="s0">* Draws the specified image centered at (</span><span class="s5">&lt;em&gt;</span><span class="s0">x</span><span class="s5">&lt;/em&gt;</span><span class="s0">, </span><span class="s5">&lt;em&gt;</span><span class="s0">y</span><span class="s5">&lt;/em&gt;</span><span class="s0">),</span>
     <span class="s0">* rotated given number of degrees.</span>
     <span class="s0">* The supported image formats are JPEG, PNG, and GIF.</span>
     <span class="s0">*</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">x the center </span><span class="s5">&lt;em&gt;</span><span class="s0">x</span><span class="s5">&lt;/em&gt;</span><span class="s0">-coordinate of the image</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">y the center </span><span class="s5">&lt;em&gt;</span><span class="s0">y</span><span class="s5">&lt;/em&gt;</span><span class="s0">-coordinate of the image</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">filename the name of the image/picture, e.g., &quot;ball.gif&quot;</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">degrees is the number of degrees to rotate counterclockwise</span>
     <span class="s0">* </span><span class="s4">@throws </span><span class="s0">IllegalArgumentException if the image filename is invalid</span>
     <span class="s0">* </span><span class="s4">@throws </span><span class="s0">IllegalArgumentException if {</span><span class="s4">@code </span><span class="s0">x}, {</span><span class="s4">@code </span><span class="s0">y}, {</span><span class="s4">@code </span><span class="s0">degrees} is NaN or infinite</span>
     <span class="s0">* </span><span class="s4">@throws </span><span class="s0">IllegalArgumentException if {</span><span class="s4">@code </span><span class="s0">filename} is {</span><span class="s4">@code </span><span class="s0">null}</span>
     <span class="s0">*/</span>
    <span class="s2">public static void </span><span class="s1">picture</span><span class="s3">(</span><span class="s2">double </span><span class="s1">x</span><span class="s3">, </span><span class="s2">double </span><span class="s1">y</span><span class="s3">, </span><span class="s1">String filename</span><span class="s3">, </span><span class="s2">double </span><span class="s1">degrees</span><span class="s3">) {</span>
        <span class="s1">validate</span><span class="s3">(</span><span class="s1">x</span><span class="s3">, </span><span class="s8">&quot;x&quot;</span><span class="s3">);</span>
        <span class="s1">validate</span><span class="s3">(</span><span class="s1">y</span><span class="s3">, </span><span class="s8">&quot;y&quot;</span><span class="s3">);</span>
        <span class="s1">validate</span><span class="s3">(</span><span class="s1">degrees</span><span class="s3">, </span><span class="s8">&quot;degrees&quot;</span><span class="s3">);</span>
        <span class="s1">validateNotNull</span><span class="s3">(</span><span class="s1">filename</span><span class="s3">, </span><span class="s8">&quot;filename&quot;</span><span class="s3">);</span>

        <span class="s7">// BufferedImage image = getImage(filename);</span>
        <span class="s1">Image image </span><span class="s3">= </span><span class="s1">getImage</span><span class="s3">(</span><span class="s1">filename</span><span class="s3">);</span>
        <span class="s2">double </span><span class="s1">xs </span><span class="s3">= </span><span class="s1">scaleX</span><span class="s3">(</span><span class="s1">x</span><span class="s3">);</span>
        <span class="s2">double </span><span class="s1">ys </span><span class="s3">= </span><span class="s1">scaleY</span><span class="s3">(</span><span class="s1">y</span><span class="s3">);</span>
        <span class="s7">// int ws = image.getWidth();    // can call only if image is a BufferedImage</span>
        <span class="s7">// int hs = image.getHeight();</span>
        <span class="s2">int </span><span class="s1">ws </span><span class="s3">= </span><span class="s1">image</span><span class="s3">.</span><span class="s1">getWidth</span><span class="s3">(</span><span class="s2">null</span><span class="s3">);</span>
        <span class="s2">int </span><span class="s1">hs </span><span class="s3">= </span><span class="s1">image</span><span class="s3">.</span><span class="s1">getHeight</span><span class="s3">(</span><span class="s2">null</span><span class="s3">);</span>
        <span class="s2">if </span><span class="s3">(</span><span class="s1">ws </span><span class="s3">&lt; </span><span class="s6">0 </span><span class="s3">|| </span><span class="s1">hs </span><span class="s3">&lt; </span><span class="s6">0</span><span class="s3">) </span><span class="s2">throw new </span><span class="s1">IllegalArgumentException</span><span class="s3">(</span><span class="s8">&quot;image &quot; </span><span class="s3">+ </span><span class="s1">filename </span><span class="s3">+ </span><span class="s8">&quot; is corrupt&quot;</span><span class="s3">);</span>

        <span class="s1">offscreen</span><span class="s3">.</span><span class="s1">rotate</span><span class="s3">(</span><span class="s1">Math</span><span class="s3">.</span><span class="s1">toRadians</span><span class="s3">(-</span><span class="s1">degrees</span><span class="s3">), </span><span class="s1">xs</span><span class="s3">, </span><span class="s1">ys</span><span class="s3">);</span>
        <span class="s1">offscreen</span><span class="s3">.</span><span class="s1">drawImage</span><span class="s3">(</span><span class="s1">image</span><span class="s3">, (</span><span class="s2">int</span><span class="s3">) </span><span class="s1">Math</span><span class="s3">.</span><span class="s1">round</span><span class="s3">(</span><span class="s1">xs </span><span class="s3">- </span><span class="s1">ws</span><span class="s3">/</span><span class="s6">2.0</span><span class="s3">), (</span><span class="s2">int</span><span class="s3">) </span><span class="s1">Math</span><span class="s3">.</span><span class="s1">round</span><span class="s3">(</span><span class="s1">ys </span><span class="s3">- </span><span class="s1">hs</span><span class="s3">/</span><span class="s6">2.0</span><span class="s3">), </span><span class="s2">null</span><span class="s3">);</span>
        <span class="s1">offscreen</span><span class="s3">.</span><span class="s1">rotate</span><span class="s3">(</span><span class="s1">Math</span><span class="s3">.</span><span class="s1">toRadians</span><span class="s3">(+</span><span class="s1">degrees</span><span class="s3">), </span><span class="s1">xs</span><span class="s3">, </span><span class="s1">ys</span><span class="s3">);</span>

        <span class="s1">draw</span><span class="s3">();</span>
    <span class="s3">}</span>

    <span class="s0">/**</span>
     <span class="s0">* Draws the specified image centered at (</span><span class="s5">&lt;em&gt;</span><span class="s0">x</span><span class="s5">&lt;/em&gt;</span><span class="s0">, </span><span class="s5">&lt;em&gt;</span><span class="s0">y</span><span class="s5">&lt;/em&gt;</span><span class="s0">),</span>
     <span class="s0">* rescaled to the specified bounding box.</span>
     <span class="s0">* The supported image formats are JPEG, PNG, and GIF.</span>
     <span class="s0">*</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">x the center </span><span class="s5">&lt;em&gt;</span><span class="s0">x</span><span class="s5">&lt;/em&gt;</span><span class="s0">-coordinate of the image</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">y the center </span><span class="s5">&lt;em&gt;</span><span class="s0">y</span><span class="s5">&lt;/em&gt;</span><span class="s0">-coordinate of the image</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">filename the name of the image/picture, e.g., &quot;ball.gif&quot;</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">scaledWidth the width of the scaled image (in screen coordinates)</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">scaledHeight the height of the scaled image (in screen coordinates)</span>
     <span class="s0">* </span><span class="s4">@throws </span><span class="s0">IllegalArgumentException if either {</span><span class="s4">@code </span><span class="s0">scaledWidth}</span>
     <span class="s0">*         or {</span><span class="s4">@code </span><span class="s0">scaledHeight} is negative</span>
     <span class="s0">* </span><span class="s4">@throws </span><span class="s0">IllegalArgumentException if the image filename is invalid</span>
     <span class="s0">* </span><span class="s4">@throws </span><span class="s0">IllegalArgumentException if {</span><span class="s4">@code </span><span class="s0">x} or {</span><span class="s4">@code </span><span class="s0">y} is either NaN or infinite</span>
     <span class="s0">* </span><span class="s4">@throws </span><span class="s0">IllegalArgumentException if {</span><span class="s4">@code </span><span class="s0">filename} is {</span><span class="s4">@code </span><span class="s0">null}</span>
     <span class="s0">*/</span>
    <span class="s2">public static void </span><span class="s1">picture</span><span class="s3">(</span><span class="s2">double </span><span class="s1">x</span><span class="s3">, </span><span class="s2">double </span><span class="s1">y</span><span class="s3">, </span><span class="s1">String filename</span><span class="s3">, </span><span class="s2">double </span><span class="s1">scaledWidth</span><span class="s3">, </span><span class="s2">double </span><span class="s1">scaledHeight</span><span class="s3">) {</span>
        <span class="s1">validate</span><span class="s3">(</span><span class="s1">x</span><span class="s3">, </span><span class="s8">&quot;x&quot;</span><span class="s3">);</span>
        <span class="s1">validate</span><span class="s3">(</span><span class="s1">y</span><span class="s3">, </span><span class="s8">&quot;y&quot;</span><span class="s3">);</span>
        <span class="s1">validate</span><span class="s3">(</span><span class="s1">scaledWidth</span><span class="s3">, </span><span class="s8">&quot;scaled width&quot;</span><span class="s3">);</span>
        <span class="s1">validate</span><span class="s3">(</span><span class="s1">scaledHeight</span><span class="s3">, </span><span class="s8">&quot;scaled height&quot;</span><span class="s3">);</span>
        <span class="s1">validateNotNull</span><span class="s3">(</span><span class="s1">filename</span><span class="s3">, </span><span class="s8">&quot;filename&quot;</span><span class="s3">);</span>
        <span class="s1">validateNonnegative</span><span class="s3">(</span><span class="s1">scaledWidth</span><span class="s3">, </span><span class="s8">&quot;scaled width&quot;</span><span class="s3">);</span>
        <span class="s1">validateNonnegative</span><span class="s3">(</span><span class="s1">scaledHeight</span><span class="s3">, </span><span class="s8">&quot;scaled height&quot;</span><span class="s3">);</span>

        <span class="s1">Image image </span><span class="s3">= </span><span class="s1">getImage</span><span class="s3">(</span><span class="s1">filename</span><span class="s3">);</span>
        <span class="s2">double </span><span class="s1">xs </span><span class="s3">= </span><span class="s1">scaleX</span><span class="s3">(</span><span class="s1">x</span><span class="s3">);</span>
        <span class="s2">double </span><span class="s1">ys </span><span class="s3">= </span><span class="s1">scaleY</span><span class="s3">(</span><span class="s1">y</span><span class="s3">);</span>
        <span class="s2">double </span><span class="s1">ws </span><span class="s3">= </span><span class="s1">factorX</span><span class="s3">(</span><span class="s1">scaledWidth</span><span class="s3">);</span>
        <span class="s2">double </span><span class="s1">hs </span><span class="s3">= </span><span class="s1">factorY</span><span class="s3">(</span><span class="s1">scaledHeight</span><span class="s3">);</span>
        <span class="s2">if </span><span class="s3">(</span><span class="s1">ws </span><span class="s3">&lt; </span><span class="s6">0 </span><span class="s3">|| </span><span class="s1">hs </span><span class="s3">&lt; </span><span class="s6">0</span><span class="s3">) </span><span class="s2">throw new </span><span class="s1">IllegalArgumentException</span><span class="s3">(</span><span class="s8">&quot;image &quot; </span><span class="s3">+ </span><span class="s1">filename </span><span class="s3">+ </span><span class="s8">&quot; is corrupt&quot;</span><span class="s3">);</span>
        <span class="s2">if </span><span class="s3">(</span><span class="s1">ws </span><span class="s3">&lt;= </span><span class="s6">1 </span><span class="s3">&amp;&amp; </span><span class="s1">hs </span><span class="s3">&lt;= </span><span class="s6">1</span><span class="s3">) </span><span class="s1">pixel</span><span class="s3">(</span><span class="s1">x</span><span class="s3">, </span><span class="s1">y</span><span class="s3">);</span>
        <span class="s2">else </span><span class="s3">{</span>
            <span class="s1">offscreen</span><span class="s3">.</span><span class="s1">drawImage</span><span class="s3">(</span><span class="s1">image</span><span class="s3">, (</span><span class="s2">int</span><span class="s3">) </span><span class="s1">Math</span><span class="s3">.</span><span class="s1">round</span><span class="s3">(</span><span class="s1">xs </span><span class="s3">- </span><span class="s1">ws</span><span class="s3">/</span><span class="s6">2.0</span><span class="s3">),</span>
                    <span class="s3">(</span><span class="s2">int</span><span class="s3">) </span><span class="s1">Math</span><span class="s3">.</span><span class="s1">round</span><span class="s3">(</span><span class="s1">ys </span><span class="s3">- </span><span class="s1">hs</span><span class="s3">/</span><span class="s6">2.0</span><span class="s3">),</span>
                    <span class="s3">(</span><span class="s2">int</span><span class="s3">) </span><span class="s1">Math</span><span class="s3">.</span><span class="s1">round</span><span class="s3">(</span><span class="s1">ws</span><span class="s3">),</span>
                    <span class="s3">(</span><span class="s2">int</span><span class="s3">) </span><span class="s1">Math</span><span class="s3">.</span><span class="s1">round</span><span class="s3">(</span><span class="s1">hs</span><span class="s3">), </span><span class="s2">null</span><span class="s3">);</span>
        <span class="s3">}</span>
        <span class="s1">draw</span><span class="s3">();</span>
    <span class="s3">}</span>


    <span class="s0">/**</span>
     <span class="s0">* Draws the specified image centered at (</span><span class="s5">&lt;em&gt;</span><span class="s0">x</span><span class="s5">&lt;/em&gt;</span><span class="s0">, </span><span class="s5">&lt;em&gt;</span><span class="s0">y</span><span class="s5">&lt;/em&gt;</span><span class="s0">), rotated</span>
     <span class="s0">* given number of degrees, and rescaled to the specified bounding box.</span>
     <span class="s0">* The supported image formats are JPEG, PNG, and GIF.</span>
     <span class="s0">*</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">x the center </span><span class="s5">&lt;em&gt;</span><span class="s0">x</span><span class="s5">&lt;/em&gt;</span><span class="s0">-coordinate of the image</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">y the center </span><span class="s5">&lt;em&gt;</span><span class="s0">y</span><span class="s5">&lt;/em&gt;</span><span class="s0">-coordinate of the image</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">filename the name of the image/picture, e.g., &quot;ball.gif&quot;</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">scaledWidth the width of the scaled image (in screen coordinates)</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">scaledHeight the height of the scaled image (in screen coordinates)</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">degrees is the number of degrees to rotate counterclockwise</span>
     <span class="s0">* </span><span class="s4">@throws </span><span class="s0">IllegalArgumentException if either {</span><span class="s4">@code </span><span class="s0">scaledWidth}</span>
     <span class="s0">*         or {</span><span class="s4">@code </span><span class="s0">scaledHeight} is negative</span>
     <span class="s0">* </span><span class="s4">@throws </span><span class="s0">IllegalArgumentException if the image filename is invalid</span>
     <span class="s0">*/</span>
    <span class="s2">public static void </span><span class="s1">picture</span><span class="s3">(</span><span class="s2">double </span><span class="s1">x</span><span class="s3">, </span><span class="s2">double </span><span class="s1">y</span><span class="s3">, </span><span class="s1">String filename</span><span class="s3">, </span><span class="s2">double </span><span class="s1">scaledWidth</span><span class="s3">, </span><span class="s2">double </span><span class="s1">scaledHeight</span><span class="s3">, </span><span class="s2">double </span><span class="s1">degrees</span><span class="s3">) {</span>
        <span class="s1">validate</span><span class="s3">(</span><span class="s1">x</span><span class="s3">, </span><span class="s8">&quot;x&quot;</span><span class="s3">);</span>
        <span class="s1">validate</span><span class="s3">(</span><span class="s1">y</span><span class="s3">, </span><span class="s8">&quot;y&quot;</span><span class="s3">);</span>
        <span class="s1">validate</span><span class="s3">(</span><span class="s1">scaledWidth</span><span class="s3">, </span><span class="s8">&quot;scaled width&quot;</span><span class="s3">);</span>
        <span class="s1">validate</span><span class="s3">(</span><span class="s1">scaledHeight</span><span class="s3">, </span><span class="s8">&quot;scaled height&quot;</span><span class="s3">);</span>
        <span class="s1">validate</span><span class="s3">(</span><span class="s1">degrees</span><span class="s3">, </span><span class="s8">&quot;degrees&quot;</span><span class="s3">);</span>
        <span class="s1">validateNotNull</span><span class="s3">(</span><span class="s1">filename</span><span class="s3">, </span><span class="s8">&quot;filename&quot;</span><span class="s3">);</span>
        <span class="s1">validateNonnegative</span><span class="s3">(</span><span class="s1">scaledWidth</span><span class="s3">, </span><span class="s8">&quot;scaled width&quot;</span><span class="s3">);</span>
        <span class="s1">validateNonnegative</span><span class="s3">(</span><span class="s1">scaledHeight</span><span class="s3">, </span><span class="s8">&quot;scaled height&quot;</span><span class="s3">);</span>

        <span class="s1">Image image </span><span class="s3">= </span><span class="s1">getImage</span><span class="s3">(</span><span class="s1">filename</span><span class="s3">);</span>
        <span class="s2">double </span><span class="s1">xs </span><span class="s3">= </span><span class="s1">scaleX</span><span class="s3">(</span><span class="s1">x</span><span class="s3">);</span>
        <span class="s2">double </span><span class="s1">ys </span><span class="s3">= </span><span class="s1">scaleY</span><span class="s3">(</span><span class="s1">y</span><span class="s3">);</span>
        <span class="s2">double </span><span class="s1">ws </span><span class="s3">= </span><span class="s1">factorX</span><span class="s3">(</span><span class="s1">scaledWidth</span><span class="s3">);</span>
        <span class="s2">double </span><span class="s1">hs </span><span class="s3">= </span><span class="s1">factorY</span><span class="s3">(</span><span class="s1">scaledHeight</span><span class="s3">);</span>
        <span class="s2">if </span><span class="s3">(</span><span class="s1">ws </span><span class="s3">&lt; </span><span class="s6">0 </span><span class="s3">|| </span><span class="s1">hs </span><span class="s3">&lt; </span><span class="s6">0</span><span class="s3">) </span><span class="s2">throw new </span><span class="s1">IllegalArgumentException</span><span class="s3">(</span><span class="s8">&quot;image &quot; </span><span class="s3">+ </span><span class="s1">filename </span><span class="s3">+ </span><span class="s8">&quot; is corrupt&quot;</span><span class="s3">);</span>
        <span class="s2">if </span><span class="s3">(</span><span class="s1">ws </span><span class="s3">&lt;= </span><span class="s6">1 </span><span class="s3">&amp;&amp; </span><span class="s1">hs </span><span class="s3">&lt;= </span><span class="s6">1</span><span class="s3">) </span><span class="s1">pixel</span><span class="s3">(</span><span class="s1">x</span><span class="s3">, </span><span class="s1">y</span><span class="s3">);</span>

        <span class="s1">offscreen</span><span class="s3">.</span><span class="s1">rotate</span><span class="s3">(</span><span class="s1">Math</span><span class="s3">.</span><span class="s1">toRadians</span><span class="s3">(-</span><span class="s1">degrees</span><span class="s3">), </span><span class="s1">xs</span><span class="s3">, </span><span class="s1">ys</span><span class="s3">);</span>
        <span class="s1">offscreen</span><span class="s3">.</span><span class="s1">drawImage</span><span class="s3">(</span><span class="s1">image</span><span class="s3">, (</span><span class="s2">int</span><span class="s3">) </span><span class="s1">Math</span><span class="s3">.</span><span class="s1">round</span><span class="s3">(</span><span class="s1">xs </span><span class="s3">- </span><span class="s1">ws</span><span class="s3">/</span><span class="s6">2.0</span><span class="s3">),</span>
                <span class="s3">(</span><span class="s2">int</span><span class="s3">) </span><span class="s1">Math</span><span class="s3">.</span><span class="s1">round</span><span class="s3">(</span><span class="s1">ys </span><span class="s3">- </span><span class="s1">hs</span><span class="s3">/</span><span class="s6">2.0</span><span class="s3">),</span>
                <span class="s3">(</span><span class="s2">int</span><span class="s3">) </span><span class="s1">Math</span><span class="s3">.</span><span class="s1">round</span><span class="s3">(</span><span class="s1">ws</span><span class="s3">),</span>
                <span class="s3">(</span><span class="s2">int</span><span class="s3">) </span><span class="s1">Math</span><span class="s3">.</span><span class="s1">round</span><span class="s3">(</span><span class="s1">hs</span><span class="s3">), </span><span class="s2">null</span><span class="s3">);</span>
        <span class="s1">offscreen</span><span class="s3">.</span><span class="s1">rotate</span><span class="s3">(</span><span class="s1">Math</span><span class="s3">.</span><span class="s1">toRadians</span><span class="s3">(+</span><span class="s1">degrees</span><span class="s3">), </span><span class="s1">xs</span><span class="s3">, </span><span class="s1">ys</span><span class="s3">);</span>

        <span class="s1">draw</span><span class="s3">();</span>
    <span class="s3">}</span>

    <span class="s0">/***************************************************************************</span>
     <span class="s0">*  Drawing text.</span>
     <span class="s0">***************************************************************************/</span>

    <span class="s0">/**</span>
     <span class="s0">* Writes the given text string in the current font, centered at (</span><span class="s5">&lt;em&gt;</span><span class="s0">x</span><span class="s5">&lt;/em&gt;</span><span class="s0">, </span><span class="s5">&lt;em&gt;</span><span class="s0">y</span><span class="s5">&lt;/em&gt;</span><span class="s0">).</span>
     <span class="s0">*</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">x the center </span><span class="s5">&lt;em&gt;</span><span class="s0">x</span><span class="s5">&lt;/em&gt;</span><span class="s0">-coordinate of the text</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">y the center </span><span class="s5">&lt;em&gt;</span><span class="s0">y</span><span class="s5">&lt;/em&gt;</span><span class="s0">-coordinate of the text</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">text the text to write</span>
     <span class="s0">* </span><span class="s4">@throws </span><span class="s0">IllegalArgumentException if {</span><span class="s4">@code </span><span class="s0">text} is {</span><span class="s4">@code </span><span class="s0">null}</span>
     <span class="s0">* </span><span class="s4">@throws </span><span class="s0">IllegalArgumentException if {</span><span class="s4">@code </span><span class="s0">x} or {</span><span class="s4">@code </span><span class="s0">y} is either NaN or infinite</span>
     <span class="s0">*/</span>
    <span class="s2">public static void </span><span class="s1">text</span><span class="s3">(</span><span class="s2">double </span><span class="s1">x</span><span class="s3">, </span><span class="s2">double </span><span class="s1">y</span><span class="s3">, </span><span class="s1">String text</span><span class="s3">) {</span>
        <span class="s1">validate</span><span class="s3">(</span><span class="s1">x</span><span class="s3">, </span><span class="s8">&quot;x&quot;</span><span class="s3">);</span>
        <span class="s1">validate</span><span class="s3">(</span><span class="s1">y</span><span class="s3">, </span><span class="s8">&quot;y&quot;</span><span class="s3">);</span>
        <span class="s1">validateNotNull</span><span class="s3">(</span><span class="s1">text</span><span class="s3">, </span><span class="s8">&quot;text&quot;</span><span class="s3">);</span>

        <span class="s1">offscreen</span><span class="s3">.</span><span class="s1">setFont</span><span class="s3">(</span><span class="s1">font</span><span class="s3">);</span>
        <span class="s1">FontMetrics metrics </span><span class="s3">= </span><span class="s1">offscreen</span><span class="s3">.</span><span class="s1">getFontMetrics</span><span class="s3">();</span>
        <span class="s2">double </span><span class="s1">xs </span><span class="s3">= </span><span class="s1">scaleX</span><span class="s3">(</span><span class="s1">x</span><span class="s3">);</span>
        <span class="s2">double </span><span class="s1">ys </span><span class="s3">= </span><span class="s1">scaleY</span><span class="s3">(</span><span class="s1">y</span><span class="s3">);</span>
        <span class="s2">int </span><span class="s1">ws </span><span class="s3">= </span><span class="s1">metrics</span><span class="s3">.</span><span class="s1">stringWidth</span><span class="s3">(</span><span class="s1">text</span><span class="s3">);</span>
        <span class="s2">int </span><span class="s1">hs </span><span class="s3">= </span><span class="s1">metrics</span><span class="s3">.</span><span class="s1">getDescent</span><span class="s3">();</span>
        <span class="s1">offscreen</span><span class="s3">.</span><span class="s1">drawString</span><span class="s3">(</span><span class="s1">text</span><span class="s3">, (</span><span class="s2">float</span><span class="s3">) (</span><span class="s1">xs </span><span class="s3">- </span><span class="s1">ws</span><span class="s3">/</span><span class="s6">2.0</span><span class="s3">), (</span><span class="s2">float</span><span class="s3">) (</span><span class="s1">ys </span><span class="s3">+ </span><span class="s1">hs</span><span class="s3">));</span>
        <span class="s1">draw</span><span class="s3">();</span>
    <span class="s3">}</span>

    <span class="s0">/**</span>
     <span class="s0">* Writes the given text string in the current font, centered at (</span><span class="s5">&lt;em&gt;</span><span class="s0">x</span><span class="s5">&lt;/em&gt;</span><span class="s0">, </span><span class="s5">&lt;em&gt;</span><span class="s0">y</span><span class="s5">&lt;/em&gt;</span><span class="s0">) and</span>
     <span class="s0">* rotated by the specified number of degrees.</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">x the center </span><span class="s5">&lt;em&gt;</span><span class="s0">x</span><span class="s5">&lt;/em&gt;</span><span class="s0">-coordinate of the text</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">y the center </span><span class="s5">&lt;em&gt;</span><span class="s0">y</span><span class="s5">&lt;/em&gt;</span><span class="s0">-coordinate of the text</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">text the text to write</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">degrees is the number of degrees to rotate counterclockwise</span>
     <span class="s0">* </span><span class="s4">@throws </span><span class="s0">IllegalArgumentException if {</span><span class="s4">@code </span><span class="s0">text} is {</span><span class="s4">@code </span><span class="s0">null}</span>
     <span class="s0">* </span><span class="s4">@throws </span><span class="s0">IllegalArgumentException if {</span><span class="s4">@code </span><span class="s0">x}, {</span><span class="s4">@code </span><span class="s0">y}, or {</span><span class="s4">@code </span><span class="s0">degrees} is either NaN or infinite</span>
     <span class="s0">*/</span>
    <span class="s2">public static void </span><span class="s1">text</span><span class="s3">(</span><span class="s2">double </span><span class="s1">x</span><span class="s3">, </span><span class="s2">double </span><span class="s1">y</span><span class="s3">, </span><span class="s1">String text</span><span class="s3">, </span><span class="s2">double </span><span class="s1">degrees</span><span class="s3">) {</span>
        <span class="s1">validate</span><span class="s3">(</span><span class="s1">x</span><span class="s3">, </span><span class="s8">&quot;x&quot;</span><span class="s3">);</span>
        <span class="s1">validate</span><span class="s3">(</span><span class="s1">y</span><span class="s3">, </span><span class="s8">&quot;y&quot;</span><span class="s3">);</span>
        <span class="s1">validate</span><span class="s3">(</span><span class="s1">degrees</span><span class="s3">, </span><span class="s8">&quot;degrees&quot;</span><span class="s3">);</span>
        <span class="s1">validateNotNull</span><span class="s3">(</span><span class="s1">text</span><span class="s3">, </span><span class="s8">&quot;text&quot;</span><span class="s3">);</span>

        <span class="s2">double </span><span class="s1">xs </span><span class="s3">= </span><span class="s1">scaleX</span><span class="s3">(</span><span class="s1">x</span><span class="s3">);</span>
        <span class="s2">double </span><span class="s1">ys </span><span class="s3">= </span><span class="s1">scaleY</span><span class="s3">(</span><span class="s1">y</span><span class="s3">);</span>
        <span class="s1">offscreen</span><span class="s3">.</span><span class="s1">rotate</span><span class="s3">(</span><span class="s1">Math</span><span class="s3">.</span><span class="s1">toRadians</span><span class="s3">(-</span><span class="s1">degrees</span><span class="s3">), </span><span class="s1">xs</span><span class="s3">, </span><span class="s1">ys</span><span class="s3">);</span>
        <span class="s1">text</span><span class="s3">(</span><span class="s1">x</span><span class="s3">, </span><span class="s1">y</span><span class="s3">, </span><span class="s1">text</span><span class="s3">);</span>
        <span class="s1">offscreen</span><span class="s3">.</span><span class="s1">rotate</span><span class="s3">(</span><span class="s1">Math</span><span class="s3">.</span><span class="s1">toRadians</span><span class="s3">(+</span><span class="s1">degrees</span><span class="s3">), </span><span class="s1">xs</span><span class="s3">, </span><span class="s1">ys</span><span class="s3">);</span>
    <span class="s3">}</span>


    <span class="s0">/**</span>
     <span class="s0">* Writes the given text string in the current font, left-aligned at (</span><span class="s5">&lt;em&gt;</span><span class="s0">x</span><span class="s5">&lt;/em&gt;</span><span class="s0">, </span><span class="s5">&lt;em&gt;</span><span class="s0">y</span><span class="s5">&lt;/em&gt;</span><span class="s0">).</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">x the </span><span class="s5">&lt;em&gt;</span><span class="s0">x</span><span class="s5">&lt;/em&gt;</span><span class="s0">-coordinate of the text</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">y the </span><span class="s5">&lt;em&gt;</span><span class="s0">y</span><span class="s5">&lt;/em&gt;</span><span class="s0">-coordinate of the text</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">text the text</span>
     <span class="s0">* </span><span class="s4">@throws </span><span class="s0">IllegalArgumentException if {</span><span class="s4">@code </span><span class="s0">text} is {</span><span class="s4">@code </span><span class="s0">null}</span>
     <span class="s0">* </span><span class="s4">@throws </span><span class="s0">IllegalArgumentException if {</span><span class="s4">@code </span><span class="s0">x} or {</span><span class="s4">@code </span><span class="s0">y} is either NaN or infinite</span>
     <span class="s0">*/</span>
    <span class="s2">public static void </span><span class="s1">textLeft</span><span class="s3">(</span><span class="s2">double </span><span class="s1">x</span><span class="s3">, </span><span class="s2">double </span><span class="s1">y</span><span class="s3">, </span><span class="s1">String text</span><span class="s3">) {</span>
        <span class="s1">validate</span><span class="s3">(</span><span class="s1">x</span><span class="s3">, </span><span class="s8">&quot;x&quot;</span><span class="s3">);</span>
        <span class="s1">validate</span><span class="s3">(</span><span class="s1">y</span><span class="s3">, </span><span class="s8">&quot;y&quot;</span><span class="s3">);</span>
        <span class="s1">validateNotNull</span><span class="s3">(</span><span class="s1">text</span><span class="s3">, </span><span class="s8">&quot;text&quot;</span><span class="s3">);</span>

        <span class="s1">offscreen</span><span class="s3">.</span><span class="s1">setFont</span><span class="s3">(</span><span class="s1">font</span><span class="s3">);</span>
        <span class="s1">FontMetrics metrics </span><span class="s3">= </span><span class="s1">offscreen</span><span class="s3">.</span><span class="s1">getFontMetrics</span><span class="s3">();</span>
        <span class="s2">double </span><span class="s1">xs </span><span class="s3">= </span><span class="s1">scaleX</span><span class="s3">(</span><span class="s1">x</span><span class="s3">);</span>
        <span class="s2">double </span><span class="s1">ys </span><span class="s3">= </span><span class="s1">scaleY</span><span class="s3">(</span><span class="s1">y</span><span class="s3">);</span>
        <span class="s2">int </span><span class="s1">hs </span><span class="s3">= </span><span class="s1">metrics</span><span class="s3">.</span><span class="s1">getDescent</span><span class="s3">();</span>
        <span class="s1">offscreen</span><span class="s3">.</span><span class="s1">drawString</span><span class="s3">(</span><span class="s1">text</span><span class="s3">, (</span><span class="s2">float</span><span class="s3">) </span><span class="s1">xs</span><span class="s3">, (</span><span class="s2">float</span><span class="s3">) (</span><span class="s1">ys </span><span class="s3">+ </span><span class="s1">hs</span><span class="s3">));</span>
        <span class="s1">draw</span><span class="s3">();</span>
    <span class="s3">}</span>

    <span class="s0">/**</span>
     <span class="s0">* Writes the given text string in the current font, right-aligned at (</span><span class="s5">&lt;em&gt;</span><span class="s0">x</span><span class="s5">&lt;/em&gt;</span><span class="s0">, </span><span class="s5">&lt;em&gt;</span><span class="s0">y</span><span class="s5">&lt;/em&gt;</span><span class="s0">).</span>
     <span class="s0">*</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">x the </span><span class="s5">&lt;em&gt;</span><span class="s0">x</span><span class="s5">&lt;/em&gt;</span><span class="s0">-coordinate of the text</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">y the </span><span class="s5">&lt;em&gt;</span><span class="s0">y</span><span class="s5">&lt;/em&gt;</span><span class="s0">-coordinate of the text</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">text the text to write</span>
     <span class="s0">* </span><span class="s4">@throws </span><span class="s0">IllegalArgumentException if {</span><span class="s4">@code </span><span class="s0">text} is {</span><span class="s4">@code </span><span class="s0">null}</span>
     <span class="s0">* </span><span class="s4">@throws </span><span class="s0">IllegalArgumentException if {</span><span class="s4">@code </span><span class="s0">x} or {</span><span class="s4">@code </span><span class="s0">y} is either NaN or infinite</span>
     <span class="s0">*/</span>
    <span class="s2">public static void </span><span class="s1">textRight</span><span class="s3">(</span><span class="s2">double </span><span class="s1">x</span><span class="s3">, </span><span class="s2">double </span><span class="s1">y</span><span class="s3">, </span><span class="s1">String text</span><span class="s3">) {</span>
        <span class="s1">validate</span><span class="s3">(</span><span class="s1">x</span><span class="s3">, </span><span class="s8">&quot;x&quot;</span><span class="s3">);</span>
        <span class="s1">validate</span><span class="s3">(</span><span class="s1">y</span><span class="s3">, </span><span class="s8">&quot;y&quot;</span><span class="s3">);</span>
        <span class="s1">validateNotNull</span><span class="s3">(</span><span class="s1">text</span><span class="s3">, </span><span class="s8">&quot;text&quot;</span><span class="s3">);</span>

        <span class="s1">offscreen</span><span class="s3">.</span><span class="s1">setFont</span><span class="s3">(</span><span class="s1">font</span><span class="s3">);</span>
        <span class="s1">FontMetrics metrics </span><span class="s3">= </span><span class="s1">offscreen</span><span class="s3">.</span><span class="s1">getFontMetrics</span><span class="s3">();</span>
        <span class="s2">double </span><span class="s1">xs </span><span class="s3">= </span><span class="s1">scaleX</span><span class="s3">(</span><span class="s1">x</span><span class="s3">);</span>
        <span class="s2">double </span><span class="s1">ys </span><span class="s3">= </span><span class="s1">scaleY</span><span class="s3">(</span><span class="s1">y</span><span class="s3">);</span>
        <span class="s2">int </span><span class="s1">ws </span><span class="s3">= </span><span class="s1">metrics</span><span class="s3">.</span><span class="s1">stringWidth</span><span class="s3">(</span><span class="s1">text</span><span class="s3">);</span>
        <span class="s2">int </span><span class="s1">hs </span><span class="s3">= </span><span class="s1">metrics</span><span class="s3">.</span><span class="s1">getDescent</span><span class="s3">();</span>
        <span class="s1">offscreen</span><span class="s3">.</span><span class="s1">drawString</span><span class="s3">(</span><span class="s1">text</span><span class="s3">, (</span><span class="s2">float</span><span class="s3">) (</span><span class="s1">xs </span><span class="s3">- </span><span class="s1">ws</span><span class="s3">), (</span><span class="s2">float</span><span class="s3">) (</span><span class="s1">ys </span><span class="s3">+ </span><span class="s1">hs</span><span class="s3">));</span>
        <span class="s1">draw</span><span class="s3">();</span>
    <span class="s3">}</span>


    <span class="s0">/**</span>
     <span class="s0">* Copies the offscreen buffer to the onscreen buffer, pauses for t milliseconds</span>
     <span class="s0">* and enables double buffering.</span>
     <span class="s0">* </span><span class="s4">@param </span><span class="s0">t number of milliseconds</span>
     <span class="s0">* </span><span class="s4">@deprecated </span><span class="s0">replaced by {</span><span class="s4">@link </span><span class="s0">#enableDoubleBuffering()}, {</span><span class="s4">@link </span><span class="s0">#show()}, and {</span><span class="s4">@link </span><span class="s0">#pause(int t)}</span>
     <span class="s0">*/</span>
    <span class="s1">@Deprecated</span>
    <span class="s2">public static void </span><span class="s1">show</span><span class="s3">(</span><span class="s2">int </span><span class="s1">t</span><span class="s3">) {</span>
        <span class="s1">validateNonnegative</span><span class="s3">(</span><span class="s1">t</span><span class="s3">, </span><span class="s8">&quot;t&quot;</span><span class="s3">);</span>
        <span class="s1">show</span><span class="s3">();</span>
        <span class="s1">pause</span><span class="s3">(</span><span class="s1">t</span><span class="s3">);</span>
        <span class="s1">enableDoubleBuffering</span><span class="s3">();</span>
    <span class="s3">}</span>

    <span class="s0">/**</span>
     <span class="s0">* Pauses for t milliseconds. This method is intended to support computer animations.</span>
     <span class="s0">* </span><span class="s4">@param </span><span class="s0">t number of milliseconds</span>
     <span class="s0">*/</span>
    <span class="s2">public static void </span><span class="s1">pause</span><span class="s3">(</span><span class="s2">int </span><span class="s1">t</span><span class="s3">) {</span>
        <span class="s1">validateNonnegative</span><span class="s3">(</span><span class="s1">t</span><span class="s3">, </span><span class="s8">&quot;t&quot;</span><span class="s3">);</span>
        <span class="s2">try </span><span class="s3">{</span>
            <span class="s1">Thread</span><span class="s3">.</span><span class="s1">sleep</span><span class="s3">(</span><span class="s1">t</span><span class="s3">);</span>
        <span class="s3">}</span>
        <span class="s2">catch </span><span class="s3">(</span><span class="s1">InterruptedException e</span><span class="s3">) {</span>
            <span class="s1">System</span><span class="s3">.</span><span class="s1">out</span><span class="s3">.</span><span class="s1">println</span><span class="s3">(</span><span class="s8">&quot;Error sleeping&quot;</span><span class="s3">);</span>
        <span class="s3">}</span>
    <span class="s3">}</span>

    <span class="s0">/**</span>
     <span class="s0">* Copies offscreen buffer to onscreen buffer. There is no reason to call</span>
     <span class="s0">* this method unless double buffering is enabled.</span>
     <span class="s0">*/</span>
    <span class="s2">public static void </span><span class="s1">show</span><span class="s3">() {</span>
        <span class="s1">onscreen</span><span class="s3">.</span><span class="s1">drawImage</span><span class="s3">(</span><span class="s1">offscreenImage</span><span class="s3">, </span><span class="s6">0</span><span class="s3">, </span><span class="s6">0</span><span class="s3">, </span><span class="s2">null</span><span class="s3">);</span>
        <span class="s1">frame</span><span class="s3">.</span><span class="s1">repaint</span><span class="s3">();</span>
    <span class="s3">}</span>

    <span class="s7">// draw onscreen if defer is false</span>
    <span class="s2">private static void </span><span class="s1">draw</span><span class="s3">() {</span>
        <span class="s2">if </span><span class="s3">(!</span><span class="s1">defer</span><span class="s3">) </span><span class="s1">show</span><span class="s3">();</span>
    <span class="s3">}</span>

    <span class="s0">/**</span>
     <span class="s0">* Enables double buffering. All subsequent calls to</span>
     <span class="s0">* drawing methods such as {</span><span class="s4">@code </span><span class="s0">line()}, {</span><span class="s4">@code </span><span class="s0">circle()},</span>
     <span class="s0">* and {</span><span class="s4">@code </span><span class="s0">square()} will be deferred until the next call</span>
     <span class="s0">* to show(). Useful for animations.</span>
     <span class="s0">*/</span>
    <span class="s2">public static void </span><span class="s1">enableDoubleBuffering</span><span class="s3">() {</span>
        <span class="s1">defer </span><span class="s3">= </span><span class="s2">true</span><span class="s3">;</span>
    <span class="s3">}</span>

    <span class="s0">/**</span>
     <span class="s0">* Disables double buffering. All subsequent calls to</span>
     <span class="s0">* drawing methods such as {</span><span class="s4">@code </span><span class="s0">line()}, {</span><span class="s4">@code </span><span class="s0">circle()},</span>
     <span class="s0">* and {</span><span class="s4">@code </span><span class="s0">square()} will be displayed on screen when called.</span>
     <span class="s0">* This is the default.</span>
     <span class="s0">*/</span>
    <span class="s2">public static void </span><span class="s1">disableDoubleBuffering</span><span class="s3">() {</span>
        <span class="s1">defer </span><span class="s3">= </span><span class="s2">false</span><span class="s3">;</span>
    <span class="s3">}</span>


    <span class="s0">/***************************************************************************</span>
     <span class="s0">*  Save drawing to a file.</span>
     <span class="s0">***************************************************************************/</span>

    <span class="s0">/**</span>
     <span class="s0">* Saves the drawing to using the specified filename.</span>
     <span class="s0">* The supported image formats are JPEG and PNG;</span>
     <span class="s0">* the filename suffix must be {</span><span class="s4">@code </span><span class="s0">.jpg} or {</span><span class="s4">@code </span><span class="s0">.png}.</span>
     <span class="s0">*</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">filename the name of the file with one of the required suffixes</span>
     <span class="s0">* </span><span class="s4">@throws </span><span class="s0">IllegalArgumentException if {</span><span class="s4">@code </span><span class="s0">filename} is {</span><span class="s4">@code </span><span class="s0">null}</span>
     <span class="s0">*/</span>
    <span class="s2">public static void </span><span class="s1">save</span><span class="s3">(</span><span class="s1">String filename</span><span class="s3">) {</span>
        <span class="s1">validateNotNull</span><span class="s3">(</span><span class="s1">filename</span><span class="s3">, </span><span class="s8">&quot;filename&quot;</span><span class="s3">);</span>
        <span class="s1">File file </span><span class="s3">= </span><span class="s2">new </span><span class="s1">File</span><span class="s3">(</span><span class="s1">filename</span><span class="s3">);</span>
        <span class="s1">String suffix </span><span class="s3">= </span><span class="s1">filename</span><span class="s3">.</span><span class="s1">substring</span><span class="s3">(</span><span class="s1">filename</span><span class="s3">.</span><span class="s1">lastIndexOf</span><span class="s3">(</span><span class="s8">'.'</span><span class="s3">) + </span><span class="s6">1</span><span class="s3">);</span>

        <span class="s7">// png files</span>
        <span class="s2">if </span><span class="s3">(</span><span class="s8">&quot;png&quot;</span><span class="s3">.</span><span class="s1">equalsIgnoreCase</span><span class="s3">(</span><span class="s1">suffix</span><span class="s3">)) {</span>
            <span class="s2">try </span><span class="s3">{</span>
                <span class="s1">ImageIO</span><span class="s3">.</span><span class="s1">write</span><span class="s3">(</span><span class="s1">onscreenImage</span><span class="s3">, </span><span class="s1">suffix</span><span class="s3">, </span><span class="s1">file</span><span class="s3">);</span>
            <span class="s3">}</span>
            <span class="s2">catch </span><span class="s3">(</span><span class="s1">IOException e</span><span class="s3">) {</span>
                <span class="s1">e</span><span class="s3">.</span><span class="s1">printStackTrace</span><span class="s3">();</span>
            <span class="s3">}</span>
        <span class="s3">}</span>

        <span class="s7">// need to change from ARGB to RGB for JPEG</span>
        <span class="s7">// reference: http://archives.java.sun.com/cgi-bin/wa?A2=ind0404&amp;L=java2d-interest&amp;D=0&amp;P=2727</span>
        <span class="s2">else if </span><span class="s3">(</span><span class="s8">&quot;jpg&quot;</span><span class="s3">.</span><span class="s1">equalsIgnoreCase</span><span class="s3">(</span><span class="s1">suffix</span><span class="s3">)) {</span>
            <span class="s1">WritableRaster raster </span><span class="s3">= </span><span class="s1">onscreenImage</span><span class="s3">.</span><span class="s1">getRaster</span><span class="s3">();</span>
            <span class="s1">WritableRaster newRaster</span><span class="s3">;</span>
            <span class="s1">newRaster </span><span class="s3">= </span><span class="s1">raster</span><span class="s3">.</span><span class="s1">createWritableChild</span><span class="s3">(</span><span class="s6">0</span><span class="s3">, </span><span class="s6">0</span><span class="s3">, </span><span class="s1">width</span><span class="s3">, </span><span class="s1">height</span><span class="s3">, </span><span class="s6">0</span><span class="s3">, </span><span class="s6">0</span><span class="s3">, </span><span class="s2">new int</span><span class="s3">[] {</span><span class="s6">0</span><span class="s3">, </span><span class="s6">1</span><span class="s3">, </span><span class="s6">2</span><span class="s3">});</span>
            <span class="s1">DirectColorModel cm </span><span class="s3">= (</span><span class="s1">DirectColorModel</span><span class="s3">) </span><span class="s1">onscreenImage</span><span class="s3">.</span><span class="s1">getColorModel</span><span class="s3">();</span>
            <span class="s1">DirectColorModel newCM </span><span class="s3">= </span><span class="s2">new </span><span class="s1">DirectColorModel</span><span class="s3">(</span><span class="s1">cm</span><span class="s3">.</span><span class="s1">getPixelSize</span><span class="s3">(),</span>
                    <span class="s1">cm</span><span class="s3">.</span><span class="s1">getRedMask</span><span class="s3">(),</span>
                    <span class="s1">cm</span><span class="s3">.</span><span class="s1">getGreenMask</span><span class="s3">(),</span>
                    <span class="s1">cm</span><span class="s3">.</span><span class="s1">getBlueMask</span><span class="s3">());</span>
            <span class="s1">BufferedImage rgbBuffer </span><span class="s3">= </span><span class="s2">new </span><span class="s1">BufferedImage</span><span class="s3">(</span><span class="s1">newCM</span><span class="s3">, </span><span class="s1">newRaster</span><span class="s3">, </span><span class="s2">false</span><span class="s3">,  </span><span class="s2">null</span><span class="s3">);</span>
            <span class="s2">try </span><span class="s3">{</span>
                <span class="s1">ImageIO</span><span class="s3">.</span><span class="s1">write</span><span class="s3">(</span><span class="s1">rgbBuffer</span><span class="s3">, </span><span class="s1">suffix</span><span class="s3">, </span><span class="s1">file</span><span class="s3">);</span>
            <span class="s3">}</span>
            <span class="s2">catch </span><span class="s3">(</span><span class="s1">IOException e</span><span class="s3">) {</span>
                <span class="s1">e</span><span class="s3">.</span><span class="s1">printStackTrace</span><span class="s3">();</span>
            <span class="s3">}</span>
        <span class="s3">}</span>

        <span class="s2">else </span><span class="s3">{</span>
            <span class="s1">System</span><span class="s3">.</span><span class="s1">out</span><span class="s3">.</span><span class="s1">println</span><span class="s3">(</span><span class="s8">&quot;Invalid image file type: &quot; </span><span class="s3">+ </span><span class="s1">suffix</span><span class="s3">);</span>
        <span class="s3">}</span>
    <span class="s3">}</span>


    <span class="s0">/**</span>
     <span class="s0">* This method cannot be called directly.</span>
     <span class="s0">*/</span>
    <span class="s1">@Override</span>
    <span class="s2">public void </span><span class="s1">actionPerformed</span><span class="s3">(</span><span class="s1">ActionEvent e</span><span class="s3">) {</span>
        <span class="s1">FileDialog chooser </span><span class="s3">= </span><span class="s2">new </span><span class="s1">FileDialog</span><span class="s3">(</span><span class="s1">StdDraw</span><span class="s3">.</span><span class="s1">frame</span><span class="s3">, </span><span class="s8">&quot;Use a .png or .jpg extension&quot;</span><span class="s3">, </span><span class="s1">FileDialog</span><span class="s3">.</span><span class="s1">SAVE</span><span class="s3">);</span>
        <span class="s1">chooser</span><span class="s3">.</span><span class="s1">setVisible</span><span class="s3">(</span><span class="s2">true</span><span class="s3">);</span>
        <span class="s1">String filename </span><span class="s3">= </span><span class="s1">chooser</span><span class="s3">.</span><span class="s1">getFile</span><span class="s3">();</span>
        <span class="s2">if </span><span class="s3">(</span><span class="s1">filename </span><span class="s3">!= </span><span class="s2">null</span><span class="s3">) {</span>
            <span class="s1">StdDraw</span><span class="s3">.</span><span class="s1">save</span><span class="s3">(</span><span class="s1">chooser</span><span class="s3">.</span><span class="s1">getDirectory</span><span class="s3">() + </span><span class="s1">File</span><span class="s3">.</span><span class="s1">separator </span><span class="s3">+ </span><span class="s1">chooser</span><span class="s3">.</span><span class="s1">getFile</span><span class="s3">());</span>
        <span class="s3">}</span>
    <span class="s3">}</span>


    <span class="s0">/***************************************************************************</span>
     <span class="s0">*  Mouse interactions.</span>
     <span class="s0">***************************************************************************/</span>

    <span class="s0">/**</span>
     <span class="s0">* Returns true if the mouse is being pressed.</span>
     <span class="s0">*</span>
     <span class="s0">* </span><span class="s4">@return </span><span class="s0">{</span><span class="s4">@code </span><span class="s0">true} if the mouse is being pressed; {</span><span class="s4">@code </span><span class="s0">false} otherwise</span>
     <span class="s0">*/</span>
    <span class="s2">public static boolean </span><span class="s1">isMousePressed</span><span class="s3">() {</span>
        <span class="s2">synchronized </span><span class="s3">(</span><span class="s1">mouseLock</span><span class="s3">) {</span>
            <span class="s2">return </span><span class="s1">isMousePressed</span><span class="s3">;</span>
        <span class="s3">}</span>
    <span class="s3">}</span>

    <span class="s0">/**</span>
     <span class="s0">* Returns true if the mouse is being pressed.</span>
     <span class="s0">*</span>
     <span class="s0">* </span><span class="s4">@return </span><span class="s0">{</span><span class="s4">@code </span><span class="s0">true} if the mouse is being pressed; {</span><span class="s4">@code </span><span class="s0">false} otherwise</span>
     <span class="s0">* </span><span class="s4">@deprecated </span><span class="s0">replaced by {</span><span class="s4">@link </span><span class="s0">#isMousePressed()}</span>
     <span class="s0">*/</span>
    <span class="s1">@Deprecated</span>
    <span class="s2">public static boolean </span><span class="s1">mousePressed</span><span class="s3">() {</span>
        <span class="s2">synchronized </span><span class="s3">(</span><span class="s1">mouseLock</span><span class="s3">) {</span>
            <span class="s2">return </span><span class="s1">isMousePressed</span><span class="s3">;</span>
        <span class="s3">}</span>
    <span class="s3">}</span>

    <span class="s0">/**</span>
     <span class="s0">* Returns the </span><span class="s5">&lt;em&gt;</span><span class="s0">x</span><span class="s5">&lt;/em&gt;</span><span class="s0">-coordinate of the mouse.</span>
     <span class="s0">*</span>
     <span class="s0">* </span><span class="s4">@return </span><span class="s0">the </span><span class="s5">&lt;em&gt;</span><span class="s0">x</span><span class="s5">&lt;/em&gt;</span><span class="s0">-coordinate of the mouse</span>
     <span class="s0">*/</span>
    <span class="s2">public static double </span><span class="s1">mouseX</span><span class="s3">() {</span>
        <span class="s2">synchronized </span><span class="s3">(</span><span class="s1">mouseLock</span><span class="s3">) {</span>
            <span class="s2">return </span><span class="s1">mouseX</span><span class="s3">;</span>
        <span class="s3">}</span>
    <span class="s3">}</span>

    <span class="s0">/**</span>
     <span class="s0">* Returns the </span><span class="s5">&lt;em&gt;</span><span class="s0">y</span><span class="s5">&lt;/em&gt;</span><span class="s0">-coordinate of the mouse.</span>
     <span class="s0">*</span>
     <span class="s0">* </span><span class="s4">@return </span><span class="s5">&lt;em&gt;</span><span class="s0">y</span><span class="s5">&lt;/em&gt;</span><span class="s0">-coordinate of the mouse</span>
     <span class="s0">*/</span>
    <span class="s2">public static double </span><span class="s1">mouseY</span><span class="s3">() {</span>
        <span class="s2">synchronized </span><span class="s3">(</span><span class="s1">mouseLock</span><span class="s3">) {</span>
            <span class="s2">return </span><span class="s1">mouseY</span><span class="s3">;</span>
        <span class="s3">}</span>
    <span class="s3">}</span>


    <span class="s0">/**</span>
     <span class="s0">* This method cannot be called directly.</span>
     <span class="s0">*/</span>
    <span class="s1">@Override</span>
    <span class="s2">public void </span><span class="s1">mouseClicked</span><span class="s3">(</span><span class="s1">MouseEvent e</span><span class="s3">) {</span>
        <span class="s7">// this body is intentionally left empty</span>
    <span class="s3">}</span>

    <span class="s0">/**</span>
     <span class="s0">* This method cannot be called directly.</span>
     <span class="s0">*/</span>
    <span class="s1">@Override</span>
    <span class="s2">public void </span><span class="s1">mouseEntered</span><span class="s3">(</span><span class="s1">MouseEvent e</span><span class="s3">) {</span>
        <span class="s7">// this body is intentionally left empty</span>
    <span class="s3">}</span>

    <span class="s0">/**</span>
     <span class="s0">* This method cannot be called directly.</span>
     <span class="s0">*/</span>
    <span class="s1">@Override</span>
    <span class="s2">public void </span><span class="s1">mouseExited</span><span class="s3">(</span><span class="s1">MouseEvent e</span><span class="s3">) {</span>
        <span class="s7">// this body is intentionally left empty</span>
    <span class="s3">}</span>

    <span class="s0">/**</span>
     <span class="s0">* This method cannot be called directly.</span>
     <span class="s0">*/</span>
    <span class="s1">@Override</span>
    <span class="s2">public void </span><span class="s1">mousePressed</span><span class="s3">(</span><span class="s1">MouseEvent e</span><span class="s3">) {</span>
        <span class="s2">synchronized </span><span class="s3">(</span><span class="s1">mouseLock</span><span class="s3">) {</span>
            <span class="s1">mouseX </span><span class="s3">= </span><span class="s1">StdDraw</span><span class="s3">.</span><span class="s1">userX</span><span class="s3">(</span><span class="s1">e</span><span class="s3">.</span><span class="s1">getX</span><span class="s3">());</span>
            <span class="s1">mouseY </span><span class="s3">= </span><span class="s1">StdDraw</span><span class="s3">.</span><span class="s1">userY</span><span class="s3">(</span><span class="s1">e</span><span class="s3">.</span><span class="s1">getY</span><span class="s3">());</span>
            <span class="s1">isMousePressed </span><span class="s3">= </span><span class="s2">true</span><span class="s3">;</span>
        <span class="s3">}</span>
    <span class="s3">}</span>

    <span class="s0">/**</span>
     <span class="s0">* This method cannot be called directly.</span>
     <span class="s0">*/</span>
    <span class="s1">@Override</span>
    <span class="s2">public void </span><span class="s1">mouseReleased</span><span class="s3">(</span><span class="s1">MouseEvent e</span><span class="s3">) {</span>
        <span class="s2">synchronized </span><span class="s3">(</span><span class="s1">mouseLock</span><span class="s3">) {</span>
            <span class="s1">isMousePressed </span><span class="s3">= </span><span class="s2">false</span><span class="s3">;</span>
        <span class="s3">}</span>
    <span class="s3">}</span>

    <span class="s0">/**</span>
     <span class="s0">* This method cannot be called directly.</span>
     <span class="s0">*/</span>
    <span class="s1">@Override</span>
    <span class="s2">public void </span><span class="s1">mouseDragged</span><span class="s3">(</span><span class="s1">MouseEvent e</span><span class="s3">)  {</span>
        <span class="s2">synchronized </span><span class="s3">(</span><span class="s1">mouseLock</span><span class="s3">) {</span>
            <span class="s1">mouseX </span><span class="s3">= </span><span class="s1">StdDraw</span><span class="s3">.</span><span class="s1">userX</span><span class="s3">(</span><span class="s1">e</span><span class="s3">.</span><span class="s1">getX</span><span class="s3">());</span>
            <span class="s1">mouseY </span><span class="s3">= </span><span class="s1">StdDraw</span><span class="s3">.</span><span class="s1">userY</span><span class="s3">(</span><span class="s1">e</span><span class="s3">.</span><span class="s1">getY</span><span class="s3">());</span>
        <span class="s3">}</span>
    <span class="s3">}</span>

    <span class="s0">/**</span>
     <span class="s0">* This method cannot be called directly.</span>
     <span class="s0">*/</span>
    <span class="s1">@Override</span>
    <span class="s2">public void </span><span class="s1">mouseMoved</span><span class="s3">(</span><span class="s1">MouseEvent e</span><span class="s3">) {</span>
        <span class="s2">synchronized </span><span class="s3">(</span><span class="s1">mouseLock</span><span class="s3">) {</span>
            <span class="s1">mouseX </span><span class="s3">= </span><span class="s1">StdDraw</span><span class="s3">.</span><span class="s1">userX</span><span class="s3">(</span><span class="s1">e</span><span class="s3">.</span><span class="s1">getX</span><span class="s3">());</span>
            <span class="s1">mouseY </span><span class="s3">= </span><span class="s1">StdDraw</span><span class="s3">.</span><span class="s1">userY</span><span class="s3">(</span><span class="s1">e</span><span class="s3">.</span><span class="s1">getY</span><span class="s3">());</span>
        <span class="s3">}</span>
    <span class="s3">}</span>


    <span class="s0">/***************************************************************************</span>
     <span class="s0">*  Keyboard interactions.</span>
     <span class="s0">***************************************************************************/</span>

    <span class="s0">/**</span>
     <span class="s0">* Returns true if the user has typed a key (that has not yet been processed).</span>
     <span class="s0">*</span>
     <span class="s0">* </span><span class="s4">@return </span><span class="s0">{</span><span class="s4">@code </span><span class="s0">true} if the user has typed a key (that has not yet been processed</span>
     <span class="s0">*         by {</span><span class="s4">@link </span><span class="s0">#nextKeyTyped()}; {</span><span class="s4">@code </span><span class="s0">false} otherwise</span>
     <span class="s0">*/</span>
    <span class="s2">public static boolean </span><span class="s1">hasNextKeyTyped</span><span class="s3">() {</span>
        <span class="s2">synchronized </span><span class="s3">(</span><span class="s1">keyLock</span><span class="s3">) {</span>
            <span class="s2">return </span><span class="s3">!</span><span class="s1">keysTyped</span><span class="s3">.</span><span class="s1">isEmpty</span><span class="s3">();</span>
        <span class="s3">}</span>
    <span class="s3">}</span>

    <span class="s0">/**</span>
     <span class="s0">* Returns the next key that was typed by the user (that your program has not already processed).</span>
     <span class="s0">* This method should be preceded by a call to {</span><span class="s4">@link </span><span class="s0">#hasNextKeyTyped()} to ensure</span>
     <span class="s0">* that there is a next key to process.</span>
     <span class="s0">* This method returns a Unicode character corresponding to the key</span>
     <span class="s0">* typed (such as {</span><span class="s4">@code </span><span class="s0">'a'} or {</span><span class="s4">@code </span><span class="s0">'A'}).</span>
     <span class="s0">* It cannot identify action keys (such as F1 and arrow keys)</span>
     <span class="s0">* or modifier keys (such as control).</span>
     <span class="s0">*</span>
     <span class="s0">* </span><span class="s4">@return </span><span class="s0">the next key typed by the user (that your program has not already processed).</span>
     <span class="s0">* </span><span class="s4">@throws </span><span class="s0">NoSuchElementException if there is no remaining key</span>
     <span class="s0">*/</span>
    <span class="s2">public static char </span><span class="s1">nextKeyTyped</span><span class="s3">() {</span>
        <span class="s2">synchronized </span><span class="s3">(</span><span class="s1">keyLock</span><span class="s3">) {</span>
            <span class="s2">if </span><span class="s3">(</span><span class="s1">keysTyped</span><span class="s3">.</span><span class="s1">isEmpty</span><span class="s3">()) {</span>
                <span class="s2">throw new </span><span class="s1">NoSuchElementException</span><span class="s3">(</span><span class="s8">&quot;your program has already processed all keystrokes&quot;</span><span class="s3">);</span>
            <span class="s3">}</span>
            <span class="s2">return </span><span class="s1">keysTyped</span><span class="s3">.</span><span class="s1">remove</span><span class="s3">(</span><span class="s1">keysTyped</span><span class="s3">.</span><span class="s1">size</span><span class="s3">() - </span><span class="s6">1</span><span class="s3">);</span>
            <span class="s7">// return keysTyped.removeLast();</span>
        <span class="s3">}</span>
    <span class="s3">}</span>

    <span class="s0">/**</span>
     <span class="s0">* Returns true if the given key is being pressed.</span>
     <span class="s0">* </span><span class="s5">&lt;p&gt;</span>
     <span class="s0">* This method takes the keycode (corresponding to a physical key)</span>
     <span class="s0">*  as an argument. It can handle action keys</span>
     <span class="s0">* (such as F1 and arrow keys) and modifier keys (such as shift and control).</span>
     <span class="s0">* See {</span><span class="s4">@link </span><span class="s0">KeyEvent} for a description of key codes.</span>
     <span class="s0">*</span>
     <span class="s0">* </span><span class="s4">@param  </span><span class="s0">keycode the key to check if it is being pressed</span>
     <span class="s0">* </span><span class="s4">@return </span><span class="s0">{</span><span class="s4">@code </span><span class="s0">true} if {</span><span class="s4">@code </span><span class="s0">keycode} is currently being pressed;</span>
     <span class="s0">*         {</span><span class="s4">@code </span><span class="s0">false} otherwise</span>
     <span class="s0">*/</span>
    <span class="s2">public static boolean </span><span class="s1">isKeyPressed</span><span class="s3">(</span><span class="s2">int </span><span class="s1">keycode</span><span class="s3">) {</span>
        <span class="s2">synchronized </span><span class="s3">(</span><span class="s1">keyLock</span><span class="s3">) {</span>
            <span class="s2">return </span><span class="s1">keysDown</span><span class="s3">.</span><span class="s1">contains</span><span class="s3">(</span><span class="s1">keycode</span><span class="s3">);</span>
        <span class="s3">}</span>
    <span class="s3">}</span>


    <span class="s0">/**</span>
     <span class="s0">* This method cannot be called directly.</span>
     <span class="s0">*/</span>
    <span class="s1">@Override</span>
    <span class="s2">public void </span><span class="s1">keyTyped</span><span class="s3">(</span><span class="s1">KeyEvent e</span><span class="s3">) {</span>
        <span class="s2">synchronized </span><span class="s3">(</span><span class="s1">keyLock</span><span class="s3">) {</span>
            <span class="s1">keysTyped</span><span class="s3">.</span><span class="s1">addFirst</span><span class="s3">(</span><span class="s1">e</span><span class="s3">.</span><span class="s1">getKeyChar</span><span class="s3">());</span>
        <span class="s3">}</span>
    <span class="s3">}</span>

    <span class="s0">/**</span>
     <span class="s0">* This method cannot be called directly.</span>
     <span class="s0">*/</span>
    <span class="s1">@Override</span>
    <span class="s2">public void </span><span class="s1">keyPressed</span><span class="s3">(</span><span class="s1">KeyEvent e</span><span class="s3">) {</span>
        <span class="s2">synchronized </span><span class="s3">(</span><span class="s1">keyLock</span><span class="s3">) {</span>
            <span class="s1">keysDown</span><span class="s3">.</span><span class="s1">add</span><span class="s3">(</span><span class="s1">e</span><span class="s3">.</span><span class="s1">getKeyCode</span><span class="s3">());</span>
        <span class="s3">}</span>
    <span class="s3">}</span>

    <span class="s0">/**</span>
     <span class="s0">* This method cannot be called directly.</span>
     <span class="s0">*/</span>
    <span class="s1">@Override</span>
    <span class="s2">public void </span><span class="s1">keyReleased</span><span class="s3">(</span><span class="s1">KeyEvent e</span><span class="s3">) {</span>
        <span class="s2">synchronized </span><span class="s3">(</span><span class="s1">keyLock</span><span class="s3">) {</span>
            <span class="s1">keysDown</span><span class="s3">.</span><span class="s1">remove</span><span class="s3">(</span><span class="s1">e</span><span class="s3">.</span><span class="s1">getKeyCode</span><span class="s3">());</span>
        <span class="s3">}</span>
    <span class="s3">}</span>


    <span class="s0">/***************************************************************************</span>
     <span class="s0">*  For improved resolution on Mac Retina displays.</span>
     <span class="s0">***************************************************************************/</span>

    <span class="s2">private static class </span><span class="s1">RetinaImageIcon </span><span class="s2">extends </span><span class="s1">ImageIcon </span><span class="s3">{</span>

        <span class="s2">public </span><span class="s1">RetinaImageIcon</span><span class="s3">(</span><span class="s1">Image image</span><span class="s3">) {</span>
            <span class="s2">super</span><span class="s3">(</span><span class="s1">image</span><span class="s3">);</span>
        <span class="s3">}</span>

        <span class="s2">public int </span><span class="s1">getIconWidth</span><span class="s3">() {</span>
            <span class="s2">return super</span><span class="s3">.</span><span class="s1">getIconWidth</span><span class="s3">() / </span><span class="s6">2</span><span class="s3">;</span>
        <span class="s3">}</span>

        <span class="s0">/**</span>
         <span class="s0">* Gets the height of the icon.</span>
         <span class="s0">*</span>
         <span class="s0">* </span><span class="s4">@return </span><span class="s0">the height in pixels of this icon</span>
         <span class="s0">*/</span>
        <span class="s2">public int </span><span class="s1">getIconHeight</span><span class="s3">() {</span>
            <span class="s2">return super</span><span class="s3">.</span><span class="s1">getIconHeight</span><span class="s3">() / </span><span class="s6">2</span><span class="s3">;</span>
        <span class="s3">}</span>

        <span class="s2">public synchronized void </span><span class="s1">paintIcon</span><span class="s3">(</span><span class="s1">Component c</span><span class="s3">, </span><span class="s1">Graphics g</span><span class="s3">, </span><span class="s2">int </span><span class="s1">x</span><span class="s3">, </span><span class="s2">int </span><span class="s1">y</span><span class="s3">) {</span>
            <span class="s1">Graphics2D g2 </span><span class="s3">= (</span><span class="s1">Graphics2D</span><span class="s3">) </span><span class="s1">g</span><span class="s3">.</span><span class="s1">create</span><span class="s3">();</span>
            <span class="s1">g2</span><span class="s3">.</span><span class="s1">setRenderingHint</span><span class="s3">(</span><span class="s1">RenderingHints</span><span class="s3">.</span><span class="s1">KEY_INTERPOLATION</span><span class="s3">,</span><span class="s1">RenderingHints</span><span class="s3">.</span><span class="s1">VALUE_INTERPOLATION_BICUBIC</span><span class="s3">);</span>
            <span class="s1">g2</span><span class="s3">.</span><span class="s1">setRenderingHint</span><span class="s3">(</span><span class="s1">RenderingHints</span><span class="s3">.</span><span class="s1">KEY_RENDERING</span><span class="s3">,</span><span class="s1">RenderingHints</span><span class="s3">.</span><span class="s1">VALUE_RENDER_QUALITY</span><span class="s3">);</span>
            <span class="s1">g2</span><span class="s3">.</span><span class="s1">setRenderingHint</span><span class="s3">(</span><span class="s1">RenderingHints</span><span class="s3">.</span><span class="s1">KEY_ANTIALIASING</span><span class="s3">,</span><span class="s1">RenderingHints</span><span class="s3">.</span><span class="s1">VALUE_ANTIALIAS_ON</span><span class="s3">);</span>
            <span class="s1">g2</span><span class="s3">.</span><span class="s1">scale</span><span class="s3">(</span><span class="s6">0.5</span><span class="s3">, </span><span class="s6">0.5</span><span class="s3">);</span>
            <span class="s2">super</span><span class="s3">.</span><span class="s1">paintIcon</span><span class="s3">(</span><span class="s1">c</span><span class="s3">, </span><span class="s1">g2</span><span class="s3">, </span><span class="s1">x </span><span class="s3">* </span><span class="s6">2</span><span class="s3">, </span><span class="s1">y </span><span class="s3">* </span><span class="s6">2</span><span class="s3">);</span>
            <span class="s1">g2</span><span class="s3">.</span><span class="s1">dispose</span><span class="s3">();</span>
        <span class="s3">}</span>
    <span class="s3">}</span>


    <span class="s0">/**</span>
     <span class="s0">* Test client.</span>
     <span class="s0">*</span>
     <span class="s0">* </span><span class="s4">@param </span><span class="s0">args the command-line arguments</span>
     <span class="s0">*/</span>
    <span class="s2">public static void </span><span class="s1">main</span><span class="s3">(</span><span class="s1">String</span><span class="s3">[] </span><span class="s1">args</span><span class="s3">) {</span>
        <span class="s1">StdDraw</span><span class="s3">.</span><span class="s1">square</span><span class="s3">(</span><span class="s6">0.2</span><span class="s3">, </span><span class="s6">0.8</span><span class="s3">, </span><span class="s6">0.1</span><span class="s3">);</span>
        <span class="s1">StdDraw</span><span class="s3">.</span><span class="s1">filledSquare</span><span class="s3">(</span><span class="s6">0.8</span><span class="s3">, </span><span class="s6">0.8</span><span class="s3">, </span><span class="s6">0.2</span><span class="s3">);</span>
        <span class="s1">StdDraw</span><span class="s3">.</span><span class="s1">circle</span><span class="s3">(</span><span class="s6">0.8</span><span class="s3">, </span><span class="s6">0.2</span><span class="s3">, </span><span class="s6">0.2</span><span class="s3">);</span>

        <span class="s1">StdDraw</span><span class="s3">.</span><span class="s1">setPenColor</span><span class="s3">(</span><span class="s1">StdDraw</span><span class="s3">.</span><span class="s1">BOOK_RED</span><span class="s3">);</span>
        <span class="s1">StdDraw</span><span class="s3">.</span><span class="s1">setPenRadius</span><span class="s3">(</span><span class="s6">0.02</span><span class="s3">);</span>
        <span class="s1">StdDraw</span><span class="s3">.</span><span class="s1">arc</span><span class="s3">(</span><span class="s6">0.8</span><span class="s3">, </span><span class="s6">0.2</span><span class="s3">, </span><span class="s6">0.1</span><span class="s3">, </span><span class="s6">200</span><span class="s3">, </span><span class="s6">45</span><span class="s3">);</span>

        <span class="s7">// draw a blue diamond</span>
        <span class="s1">StdDraw</span><span class="s3">.</span><span class="s1">setPenRadius</span><span class="s3">();</span>
        <span class="s1">StdDraw</span><span class="s3">.</span><span class="s1">setPenColor</span><span class="s3">(</span><span class="s1">StdDraw</span><span class="s3">.</span><span class="s1">BOOK_BLUE</span><span class="s3">);</span>
        <span class="s2">double</span><span class="s3">[] </span><span class="s1">x </span><span class="s3">= { </span><span class="s6">0.1</span><span class="s3">, </span><span class="s6">0.2</span><span class="s3">, </span><span class="s6">0.3</span><span class="s3">, </span><span class="s6">0.2 </span><span class="s3">};</span>
        <span class="s2">double</span><span class="s3">[] </span><span class="s1">y </span><span class="s3">= { </span><span class="s6">0.2</span><span class="s3">, </span><span class="s6">0.3</span><span class="s3">, </span><span class="s6">0.2</span><span class="s3">, </span><span class="s6">0.1 </span><span class="s3">};</span>
        <span class="s1">StdDraw</span><span class="s3">.</span><span class="s1">filledPolygon</span><span class="s3">(</span><span class="s1">x</span><span class="s3">, </span><span class="s1">y</span><span class="s3">);</span>

        <span class="s7">// text</span>
        <span class="s1">StdDraw</span><span class="s3">.</span><span class="s1">setPenColor</span><span class="s3">(</span><span class="s1">StdDraw</span><span class="s3">.</span><span class="s1">BLACK</span><span class="s3">);</span>
        <span class="s1">StdDraw</span><span class="s3">.</span><span class="s1">text</span><span class="s3">(</span><span class="s6">0.2</span><span class="s3">, </span><span class="s6">0.5</span><span class="s3">, </span><span class="s8">&quot;black text&quot;</span><span class="s3">);</span>
        <span class="s1">StdDraw</span><span class="s3">.</span><span class="s1">setPenColor</span><span class="s3">(</span><span class="s1">StdDraw</span><span class="s3">.</span><span class="s1">WHITE</span><span class="s3">);</span>
        <span class="s1">StdDraw</span><span class="s3">.</span><span class="s1">text</span><span class="s3">(</span><span class="s6">0.8</span><span class="s3">, </span><span class="s6">0.8</span><span class="s3">, </span><span class="s8">&quot;white text&quot;</span><span class="s3">);</span>
    <span class="s3">}</span>

<span class="s3">}</span></pre>
</body>
</html>