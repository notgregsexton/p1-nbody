<html>
<head>
<title>NBody.java</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style type="text/css">
.s0 { color: #5f826b; font-style: italic;}
.s1 { color: #67a37c; font-style: italic;}
.s2 { color: #bcbec4;}
.s3 { color: #cf8e6d;}
.s4 { color: #bcbec4;}
.s5 { color: #7a7e85;}
.s6 { color: #2aacb8;}
.s7 { color: #6aab73;}
</style>
</head>
<body bgcolor="#1e1f22">
<table CELLSPACING=0 CELLPADDING=5 COLS=1 WIDTH="100%" BGCOLOR="#606060" >
<tr><td><center>
<font face="Arial, Helvetica" color="#000000">
NBody.java</font>
</center></td></tr></table>
<pre><span class="s0">/**</span>
 <span class="s0">* </span><span class="s1">@Gregory </span><span class="s0">Sexton</span>
 <span class="s0">*</span>
 <span class="s0">* Simulation program for the NBody assignment</span>
 <span class="s0">*/</span>

<span class="s3">import </span><span class="s2">java</span><span class="s4">.</span><span class="s2">io</span><span class="s4">.</span><span class="s2">File</span><span class="s4">;</span>
<span class="s3">import </span><span class="s2">java</span><span class="s4">.</span><span class="s2">io</span><span class="s4">.</span><span class="s2">FileNotFoundException</span><span class="s4">;</span>
<span class="s3">import </span><span class="s2">java</span><span class="s4">.</span><span class="s2">util</span><span class="s4">.*;</span>

<span class="s3">public class </span><span class="s2">NBody </span><span class="s4">{</span>
	
	<span class="s0">/**</span>
	 <span class="s0">* Read the specified file and return the radius</span>
	 <span class="s0">* </span><span class="s1">@param </span><span class="s0">fname is name of file that can be open</span>
	 <span class="s0">* </span><span class="s1">@return </span><span class="s0">the radius stored in the file</span>
	 <span class="s0">* </span><span class="s1">@throws </span><span class="s0">FileNotFoundException if fname cannot be open</span>
	 <span class="s0">*/</span>
	<span class="s3">public static double </span><span class="s2">readRadius</span><span class="s4">(</span><span class="s2">String fname</span><span class="s4">) </span><span class="s3">throws </span><span class="s2">FileNotFoundException  </span><span class="s4">{</span>
		<span class="s2">Scanner s </span><span class="s4">= </span><span class="s3">new </span><span class="s2">Scanner</span><span class="s4">(</span><span class="s3">new </span><span class="s2">File</span><span class="s4">(</span><span class="s2">fname</span><span class="s4">));</span>
	
		<span class="s5">// TODO: read values at beginning of file to</span>
		<span class="s5">// find the radius, store in variable rad and return it</span>
		<span class="s3">int </span><span class="s2">num </span><span class="s4">= </span><span class="s2">s</span><span class="s4">.</span><span class="s2">nextInt</span><span class="s4">();</span>
		<span class="s3">double </span><span class="s2">rad </span><span class="s4">= </span><span class="s2">s</span><span class="s4">.</span><span class="s2">nextDouble</span><span class="s4">();</span>
		
		<span class="s2">s</span><span class="s4">.</span><span class="s2">close</span><span class="s4">();</span>
		

		<span class="s3">return </span><span class="s2">rad</span><span class="s4">;</span>
	<span class="s4">}</span>
	
	<span class="s0">/**</span>
	 <span class="s0">* Read all data in file, return array of Celestial Bodies</span>
	 <span class="s0">* read by creating an array of Body objects from data read.</span>
	 <span class="s0">* </span><span class="s1">@param </span><span class="s0">fname is name of file that can be open</span>
	 <span class="s0">* </span><span class="s1">@return </span><span class="s0">array of Body objects read</span>
	 <span class="s0">* </span><span class="s1">@throws </span><span class="s0">FileNotFoundException if fname cannot be open</span>
	 <span class="s0">*/</span>
	<span class="s3">public static </span><span class="s2">CelestialBody</span><span class="s4">[] </span><span class="s2">readBodies</span><span class="s4">(</span><span class="s2">String fname</span><span class="s4">) </span><span class="s3">throws </span><span class="s2">FileNotFoundException </span><span class="s4">{</span>

		<span class="s2">Scanner s </span><span class="s4">= </span><span class="s3">new </span><span class="s2">Scanner</span><span class="s4">(</span><span class="s3">new </span><span class="s2">File</span><span class="s4">(</span><span class="s2">fname</span><span class="s4">));</span>
			
		<span class="s5">// TODO: read # bodies, store in nb</span>
		<span class="s5">// TODO: read and ignore radius</span>
		<span class="s3">int </span><span class="s2">numBodies </span><span class="s4">= </span><span class="s2">s</span><span class="s4">.</span><span class="s2">nextInt</span><span class="s4">(); </span><span class="s5">// # of bodies to be read</span>
		<span class="s3">double </span><span class="s2">rad </span><span class="s4">= </span><span class="s2">s</span><span class="s4">.</span><span class="s2">nextDouble</span><span class="s4">();</span>

		<span class="s5">// TODO: Create array that can store nb CelestialBodies</span>
		<span class="s2">CelestialBody</span><span class="s4">[] </span><span class="s2">bodies </span><span class="s4">= </span><span class="s3">new </span><span class="s2">CelestialBody</span><span class="s4">[</span><span class="s2">numBodies</span><span class="s4">];</span>

		<span class="s3">for</span><span class="s4">(</span><span class="s3">int </span><span class="s2">k</span><span class="s4">=</span><span class="s6">0</span><span class="s4">; </span><span class="s2">k </span><span class="s4">&lt; </span><span class="s2">numBodies</span><span class="s4">; </span><span class="s2">k</span><span class="s4">++) {</span>
			<span class="s3">double </span><span class="s2">xPos </span><span class="s4">= </span><span class="s2">s</span><span class="s4">.</span><span class="s2">nextDouble</span><span class="s4">();</span>
			<span class="s3">double </span><span class="s2">yPos </span><span class="s4">= </span><span class="s2">s</span><span class="s4">.</span><span class="s2">nextDouble</span><span class="s4">();</span>
			<span class="s3">double </span><span class="s2">xVel </span><span class="s4">= </span><span class="s2">s</span><span class="s4">.</span><span class="s2">nextDouble</span><span class="s4">();</span>
			<span class="s3">double </span><span class="s2">yVel </span><span class="s4">= </span><span class="s2">s</span><span class="s4">.</span><span class="s2">nextDouble</span><span class="s4">();</span>
			<span class="s3">double </span><span class="s2">mass </span><span class="s4">= </span><span class="s2">s</span><span class="s4">.</span><span class="s2">nextDouble</span><span class="s4">();</span>
			<span class="s2">String filename </span><span class="s4">= </span><span class="s2">s</span><span class="s4">.</span><span class="s2">next</span><span class="s4">();</span>
			<span class="s5">// TODO: read data for each body</span>
			<span class="s5">// TODO: construct new CelestialBody object and add to array</span>
			<span class="s2">bodies</span><span class="s4">[</span><span class="s2">k</span><span class="s4">] = </span><span class="s3">new </span><span class="s2">CelestialBody</span><span class="s4">(</span><span class="s2">xPos</span><span class="s4">, </span><span class="s2">yPos</span><span class="s4">, </span><span class="s2">xVel</span><span class="s4">, </span><span class="s2">yVel</span><span class="s4">, </span><span class="s2">mass</span><span class="s4">, </span><span class="s2">filename</span><span class="s4">);</span>

		<span class="s4">}</span>

		<span class="s2">s</span><span class="s4">.</span><span class="s2">close</span><span class="s4">();</span>

		<span class="s5">// TODO: return array of body objects read</span>
		<span class="s3">return </span><span class="s2">bodies</span><span class="s4">;</span>
	<span class="s4">}</span>
	<span class="s3">public static void </span><span class="s2">main</span><span class="s4">(</span><span class="s2">String</span><span class="s4">[] </span><span class="s2">args</span><span class="s4">) </span><span class="s3">throws </span><span class="s2">FileNotFoundException</span><span class="s4">{</span>
		<span class="s3">double </span><span class="s2">totalTime </span><span class="s4">= </span><span class="s6">39447000.0</span><span class="s4">;</span>
		<span class="s3">double </span><span class="s2">dt </span><span class="s4">= </span><span class="s6">25000.0</span><span class="s4">;</span>

		<span class="s2">String fname</span><span class="s4">= </span><span class="s7">&quot;./data/planets.txt&quot;</span><span class="s4">;</span>

		<span class="s3">if </span><span class="s4">(</span><span class="s2">args</span><span class="s4">.</span><span class="s2">length </span><span class="s4">&gt; </span><span class="s6">2</span><span class="s4">) {</span>
			<span class="s2">totalTime </span><span class="s4">= </span><span class="s2">Double</span><span class="s4">.</span><span class="s2">parseDouble</span><span class="s4">(</span><span class="s2">args</span><span class="s4">[</span><span class="s6">0</span><span class="s4">]);</span>
			<span class="s2">dt </span><span class="s4">= </span><span class="s2">Double</span><span class="s4">.</span><span class="s2">parseDouble</span><span class="s4">(</span><span class="s2">args</span><span class="s4">[</span><span class="s6">1</span><span class="s4">]);</span>
			<span class="s2">fname </span><span class="s4">= </span><span class="s2">args</span><span class="s4">[</span><span class="s6">2</span><span class="s4">];</span>
		<span class="s4">}</span>

		<span class="s2">CelestialBody</span><span class="s4">[] </span><span class="s2">bodies </span><span class="s4">= </span><span class="s2">readBodies</span><span class="s4">(</span><span class="s2">fname</span><span class="s4">);</span>
		<span class="s3">double </span><span class="s2">radius </span><span class="s4">= </span><span class="s2">readRadius</span><span class="s4">(</span><span class="s2">fname</span><span class="s4">);</span>

		<span class="s2">StdDraw</span><span class="s4">.</span><span class="s2">enableDoubleBuffering</span><span class="s4">();</span>
		<span class="s2">StdDraw</span><span class="s4">.</span><span class="s2">setScale</span><span class="s4">(-</span><span class="s2">radius</span><span class="s4">, </span><span class="s2">radius</span><span class="s4">);</span>
		<span class="s2">StdDraw</span><span class="s4">.</span><span class="s2">picture</span><span class="s4">(</span><span class="s6">0</span><span class="s4">,</span><span class="s6">0</span><span class="s4">,</span><span class="s7">&quot;images/starfield.jpg&quot;</span><span class="s4">);</span>

		<span class="s5">// run simulation until over</span>

		<span class="s5">// TODO: create double arrays xforces and yforces</span>
	    <span class="s5">//       to hold forces on each body</span>
		<span class="s3">double </span><span class="s4">[]</span><span class="s2">xforces </span><span class="s4">= </span><span class="s3">new double</span><span class="s4">[</span><span class="s2">bodies</span><span class="s4">.</span><span class="s2">length</span><span class="s4">];</span>
		<span class="s3">double </span><span class="s4">[]</span><span class="s2">yforces </span><span class="s4">= </span><span class="s3">new double</span><span class="s4">[</span><span class="s2">bodies</span><span class="s4">.</span><span class="s2">length</span><span class="s4">];</span>

		<span class="s3">for</span><span class="s4">(</span><span class="s3">double </span><span class="s2">t </span><span class="s4">= </span><span class="s6">0.0</span><span class="s4">; </span><span class="s2">t </span><span class="s4">&lt; </span><span class="s2">totalTime</span><span class="s4">; </span><span class="s2">t </span><span class="s4">+= </span><span class="s2">dt</span><span class="s4">) {</span>
			
			<span class="s5">// TODO: in loop, calculate netForcesX and netForcesY and store in</span>
			<span class="s5">//       arrays xforces and yforces for each object in bodies</span>

			<span class="s3">for</span><span class="s4">(</span><span class="s3">int </span><span class="s2">k</span><span class="s4">=</span><span class="s6">0</span><span class="s4">; </span><span class="s2">k </span><span class="s4">&lt; </span><span class="s2">bodies</span><span class="s4">.</span><span class="s2">length</span><span class="s4">; </span><span class="s2">k</span><span class="s4">++) {</span>
				<span class="s5">// code here</span>
				<span class="s2">xforces</span><span class="s4">[</span><span class="s2">k</span><span class="s4">] = </span><span class="s2">bodies</span><span class="s4">[</span><span class="s2">k</span><span class="s4">].</span><span class="s2">calcNetForceExertedByX</span><span class="s4">(</span><span class="s2">bodies</span><span class="s4">);</span>
				<span class="s2">yforces</span><span class="s4">[</span><span class="s2">k</span><span class="s4">] = </span><span class="s2">bodies</span><span class="s4">[</span><span class="s2">k</span><span class="s4">].</span><span class="s2">calcNetForceExertedByY</span><span class="s4">(</span><span class="s2">bodies</span><span class="s4">);</span>
  			<span class="s4">}</span>

			<span class="s5">// TODO: loop over all bodies and call update</span>
			<span class="s5">//       with dt and corresponding xforces and yforces arrays</span>

			<span class="s3">for</span><span class="s4">(</span><span class="s3">int </span><span class="s2">k</span><span class="s4">=</span><span class="s6">0</span><span class="s4">; </span><span class="s2">k </span><span class="s4">&lt; </span><span class="s2">bodies</span><span class="s4">.</span><span class="s2">length</span><span class="s4">; </span><span class="s2">k</span><span class="s4">++){</span>
				<span class="s5">// code here</span>
				<span class="s2">bodies</span><span class="s4">[</span><span class="s2">k</span><span class="s4">].</span><span class="s2">update</span><span class="s4">(</span><span class="s2">dt</span><span class="s4">, </span><span class="s2">xforces</span><span class="s4">[</span><span class="s2">k</span><span class="s4">], </span><span class="s2">yforces</span><span class="s4">[</span><span class="s2">k</span><span class="s4">]);</span>
			<span class="s4">}</span>

			<span class="s2">StdDraw</span><span class="s4">.</span><span class="s2">clear</span><span class="s4">();</span>
			<span class="s2">StdDraw</span><span class="s4">.</span><span class="s2">picture</span><span class="s4">(</span><span class="s6">0</span><span class="s4">,</span><span class="s6">0</span><span class="s4">,</span><span class="s7">&quot;images/starfield.jpg&quot;</span><span class="s4">);</span>
			
			<span class="s5">// TODO: loop over all bodies and call draw on each one</span>

			<span class="s3">for</span><span class="s4">(</span><span class="s2">CelestialBody b </span><span class="s4">: </span><span class="s2">bodies</span><span class="s4">){</span>
				<span class="s5">// code here</span>
				<span class="s2">b</span><span class="s4">.</span><span class="s2">draw</span><span class="s4">();</span>
			<span class="s4">}</span>
			<span class="s2">StdDraw</span><span class="s4">.</span><span class="s2">show</span><span class="s4">();</span>
			<span class="s2">StdDraw</span><span class="s4">.</span><span class="s2">pause</span><span class="s4">(</span><span class="s6">10</span><span class="s4">);</span>

		<span class="s4">}</span>

		<span class="s5">// prints final values after simulation</span>
		
		<span class="s2">System</span><span class="s4">.</span><span class="s2">out</span><span class="s4">.</span><span class="s2">printf</span><span class="s4">(</span><span class="s7">&quot;%d</span><span class="s3">\n</span><span class="s7">&quot;</span><span class="s4">, </span><span class="s2">bodies</span><span class="s4">.</span><span class="s2">length</span><span class="s4">);</span>
		<span class="s2">System</span><span class="s4">.</span><span class="s2">out</span><span class="s4">.</span><span class="s2">printf</span><span class="s4">(</span><span class="s7">&quot;%.2e</span><span class="s3">\n</span><span class="s7">&quot;</span><span class="s4">, </span><span class="s2">radius</span><span class="s4">);</span>
		<span class="s3">for </span><span class="s4">(</span><span class="s3">int </span><span class="s2">i </span><span class="s4">= </span><span class="s6">0</span><span class="s4">; </span><span class="s2">i </span><span class="s4">&lt; </span><span class="s2">bodies</span><span class="s4">.</span><span class="s2">length</span><span class="s4">; </span><span class="s2">i</span><span class="s4">++) {</span>
		    <span class="s2">System</span><span class="s4">.</span><span class="s2">out</span><span class="s4">.</span><span class="s2">printf</span><span class="s4">(</span><span class="s7">&quot;%11.4e %11.4e %11.4e %11.4e %11.4e %12s</span><span class="s3">\n</span><span class="s7">&quot;</span><span class="s4">,</span>
		   		              <span class="s2">bodies</span><span class="s4">[</span><span class="s2">i</span><span class="s4">].</span><span class="s2">getX</span><span class="s4">(), </span><span class="s2">bodies</span><span class="s4">[</span><span class="s2">i</span><span class="s4">].</span><span class="s2">getY</span><span class="s4">(), </span>
		                      <span class="s2">bodies</span><span class="s4">[</span><span class="s2">i</span><span class="s4">].</span><span class="s2">getXVel</span><span class="s4">(), </span><span class="s2">bodies</span><span class="s4">[</span><span class="s2">i</span><span class="s4">].</span><span class="s2">getYVel</span><span class="s4">(), </span>
		                      <span class="s2">bodies</span><span class="s4">[</span><span class="s2">i</span><span class="s4">].</span><span class="s2">getMass</span><span class="s4">(), </span><span class="s2">bodies</span><span class="s4">[</span><span class="s2">i</span><span class="s4">].</span><span class="s2">getName</span><span class="s4">());	</span>
		<span class="s4">}</span>
	<span class="s4">}</span>
<span class="s4">}</span>
</pre>
</body>
</html>