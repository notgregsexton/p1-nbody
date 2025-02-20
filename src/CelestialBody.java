<html>
<head>
<title>CelestialBody.java</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style type="text/css">
.s0 { color: #bcbec4;}
.s1 { color: #5f826b; font-style: italic;}
.s2 { color: #67a37c; font-style: italic;}
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
CelestialBody.java</font>
</center></td></tr></table>
<pre>

<span class="s1">/**</span>
 <span class="s1">* Celestial Body class for NBody</span>
 <span class="s1">* Modified from original Planet class</span>
 <span class="s1">* used at Princeton and Berkeley</span>
 <span class="s1">* </span><span class="s2">@author </span><span class="s1">Greg Sexton</span>
 <span class="s1">*</span>
 <span class="s1">* If you add code here, add yourself as @author below</span>
 <span class="s1">*</span>
 <span class="s1">*</span>
 <span class="s1">*/</span>
<span class="s3">public class </span><span class="s0">CelestialBody </span><span class="s4">{</span>

	<span class="s3">private double </span><span class="s0">myXPos</span><span class="s4">;</span>
	<span class="s3">private double </span><span class="s0">myYPos</span><span class="s4">;</span>
	<span class="s3">private double </span><span class="s0">myXVel</span><span class="s4">;</span>
	<span class="s3">private double </span><span class="s0">myYVel</span><span class="s4">;</span>
	<span class="s3">private double </span><span class="s0">myMass</span><span class="s4">;</span>
	<span class="s3">private </span><span class="s0">String myFileName</span><span class="s4">;</span>

	<span class="s1">/**</span>
	 <span class="s1">* Create a Body from parameters	</span>
	 <span class="s1">* </span><span class="s2">@param </span><span class="s1">xp initial x position</span>
	 <span class="s1">* </span><span class="s2">@param </span><span class="s1">yp initial y position</span>
	 <span class="s1">* </span><span class="s2">@param </span><span class="s1">xv initial x velocity</span>
	 <span class="s1">* </span><span class="s2">@param </span><span class="s1">yv initial y velocity</span>
	 <span class="s1">* </span><span class="s2">@param </span><span class="s1">mass of object</span>
	 <span class="s1">* </span><span class="s2">@param </span><span class="s1">filename of image for object animation</span>
	 <span class="s1">*/</span>
	<span class="s3">public </span><span class="s0">CelestialBody</span><span class="s4">(</span><span class="s3">double </span><span class="s0">xp</span><span class="s4">, </span><span class="s3">double </span><span class="s0">yp</span><span class="s4">, </span><span class="s3">double </span><span class="s0">xv</span><span class="s4">,</span>
			             <span class="s3">double </span><span class="s0">yv</span><span class="s4">, </span><span class="s3">double </span><span class="s0">mass</span><span class="s4">, </span><span class="s0">String filename</span><span class="s4">){</span>
		<span class="s5">// TODO: complete constructor</span>
		<span class="s3">this</span><span class="s4">.</span><span class="s0">myXPos </span><span class="s4">=  </span><span class="s0">xp</span><span class="s4">;</span>
		<span class="s3">this</span><span class="s4">.</span><span class="s0">myYPos </span><span class="s4">= </span><span class="s0">yp</span><span class="s4">;</span>
		<span class="s3">this</span><span class="s4">.</span><span class="s0">myXVel </span><span class="s4">= </span><span class="s0">xv</span><span class="s4">;</span>
		<span class="s3">this</span><span class="s4">.</span><span class="s0">myYVel </span><span class="s4">= </span><span class="s0">yv</span><span class="s4">;</span>
		<span class="s3">this</span><span class="s4">.</span><span class="s0">myMass </span><span class="s4">= </span><span class="s0">mass</span><span class="s4">;</span>
		<span class="s3">this</span><span class="s4">.</span><span class="s0">myFileName </span><span class="s4">= </span><span class="s0">filename</span><span class="s4">;</span>

	<span class="s4">}</span>

	<span class="s1">/**</span>
	 <span class="s1">*</span>
	 <span class="s1">* </span><span class="s2">@return</span>
	 <span class="s1">*/</span>
	<span class="s3">public double </span><span class="s0">getX</span><span class="s4">() {</span>
		<span class="s5">// TODO: complete method</span>
		<span class="s3">return </span><span class="s0">myXPos</span><span class="s4">;</span>
	<span class="s4">}</span>

	<span class="s1">/**</span>
	 <span class="s1">*</span>
	 <span class="s1">* </span><span class="s2">@return</span>
	 <span class="s1">*/</span>
	<span class="s3">public double </span><span class="s0">getY</span><span class="s4">() {</span>
		<span class="s5">// TODO: complete method</span>
		<span class="s3">return </span><span class="s0">myYPos</span><span class="s4">;</span>
	<span class="s4">}</span>

	<span class="s1">/**</span>
	 <span class="s1">* Accessor for the x-velocity</span>
	 <span class="s1">* </span><span class="s2">@return </span><span class="s1">the value of this object's x-velocity</span>
	 <span class="s1">*/</span>
	<span class="s3">public double </span><span class="s0">getXVel</span><span class="s4">() {</span>
		<span class="s5">// TODO: complete method</span>
		<span class="s3">return </span><span class="s0">myXVel</span><span class="s4">;</span>
	<span class="s4">}</span>
	<span class="s1">/**</span>
	 <span class="s1">* Accessor for the y-velocity.</span>
	 <span class="s1">* </span><span class="s2">@return </span><span class="s1">value of this object's y-velocity</span>
	 <span class="s1">*/</span>
	<span class="s3">public double </span><span class="s0">getYVel</span><span class="s4">() {</span>
		<span class="s5">// TODO: complete method</span>
		<span class="s3">return </span><span class="s0">myYVel</span><span class="s4">;</span>
	<span class="s4">}</span>

	<span class="s1">/**</span>
	 <span class="s1">*</span>
	 <span class="s1">* </span><span class="s2">@return</span>
	 <span class="s1">*/</span>
	<span class="s3">public double </span><span class="s0">getMass</span><span class="s4">() {</span>
		<span class="s5">// TODO: complete method</span>
		<span class="s3">return </span><span class="s0">myMass</span><span class="s4">;</span>
	<span class="s4">}</span>

	<span class="s1">/**</span>
	 <span class="s1">*</span>
	 <span class="s1">* </span><span class="s2">@return</span>
	 <span class="s1">*/</span>
	<span class="s3">public </span><span class="s0">String getName</span><span class="s4">() {</span>
		<span class="s5">// TODO: complete method</span>
		<span class="s3">return </span><span class="s0">myFileName</span><span class="s4">;</span>
	<span class="s4">}</span>

	<span class="s1">/**</span>
	 <span class="s1">* Return the distance between this body and another</span>
	 <span class="s1">* </span><span class="s2">@param </span><span class="s1">b the other body to which distance is calculated</span>
	 <span class="s1">* </span><span class="s2">@return </span><span class="s1">distance between this body and b</span>
	 <span class="s1">*/</span>
	<span class="s3">public double </span><span class="s0">calcDistance</span><span class="s4">(</span><span class="s0">CelestialBody b</span><span class="s4">) {</span>
		<span class="s5">// TODO: complete method</span>
		<span class="s3">double </span><span class="s0">distx </span><span class="s4">= </span><span class="s0">b</span><span class="s4">.</span><span class="s0">getX</span><span class="s4">() - </span><span class="s3">this</span><span class="s4">.</span><span class="s0">myXPos</span><span class="s4">;</span>
		<span class="s3">double </span><span class="s0">disty </span><span class="s4">= </span><span class="s0">b</span><span class="s4">.</span><span class="s0">getY</span><span class="s4">() - </span><span class="s3">this</span><span class="s4">.</span><span class="s0">myYPos</span><span class="s4">;</span>
		<span class="s3">return </span><span class="s0">Math</span><span class="s4">.</span><span class="s0">sqrt</span><span class="s4">(</span><span class="s0">distx </span><span class="s4">* </span><span class="s0">distx </span><span class="s4">+ </span><span class="s0">disty </span><span class="s4">* </span><span class="s0">disty</span><span class="s4">);</span>
	<span class="s4">}</span>

	<span class="s3">public double </span><span class="s0">calcForceExertedBy</span><span class="s4">(</span><span class="s0">CelestialBody b</span><span class="s4">) {</span>
		<span class="s5">// TODO: complete method</span>
		<span class="s3">double </span><span class="s0">G </span><span class="s4">= </span><span class="s6">6.67</span><span class="s4">*</span><span class="s6">1e-11</span><span class="s4">;</span>
		<span class="s3">double </span><span class="s0">r </span><span class="s4">= </span><span class="s3">this</span><span class="s4">.</span><span class="s0">calcDistance</span><span class="s4">(</span><span class="s0">b</span><span class="s4">);</span>
		<span class="s3">double </span><span class="s0">f </span><span class="s4">= (</span><span class="s0">G </span><span class="s4">* </span><span class="s0">myMass </span><span class="s4">* </span><span class="s0">b</span><span class="s4">.</span><span class="s0">getMass</span><span class="s4">()) / (</span><span class="s0">r </span><span class="s4">* </span><span class="s0">r</span><span class="s4">);</span>
		<span class="s3">return </span><span class="s0">f</span><span class="s4">;</span>
	<span class="s4">}</span>

	<span class="s3">public double </span><span class="s0">calcForceExertedByX</span><span class="s4">(</span><span class="s0">CelestialBody b</span><span class="s4">) {</span>
		<span class="s5">// TODO: complete method</span>
		<span class="s3">double </span><span class="s0">F </span><span class="s4">= </span><span class="s0">calcForceExertedBy</span><span class="s4">(</span><span class="s0">b</span><span class="s4">);</span>
		<span class="s3">double </span><span class="s0">r </span><span class="s4">= </span><span class="s0">calcDistance</span><span class="s4">(</span><span class="s0">b</span><span class="s4">);</span>
		<span class="s3">double </span><span class="s0">dx </span><span class="s4">= </span><span class="s0">b</span><span class="s4">.</span><span class="s0">getX</span><span class="s4">() - </span><span class="s3">this</span><span class="s4">.</span><span class="s0">getX</span><span class="s4">();</span>
		<span class="s3">double </span><span class="s0">Fx </span><span class="s4">= </span><span class="s0">F </span><span class="s4">* </span><span class="s0">dx</span><span class="s4">/</span><span class="s0">r</span><span class="s4">;</span>
		<span class="s3">return </span><span class="s0">Fx</span><span class="s4">;</span>

	<span class="s4">}</span>
	<span class="s3">public double </span><span class="s0">calcForceExertedByY</span><span class="s4">(</span><span class="s0">CelestialBody b</span><span class="s4">) {</span>
		<span class="s5">// TODO: complete method</span>
		<span class="s3">double </span><span class="s0">F </span><span class="s4">= </span><span class="s0">calcForceExertedBy</span><span class="s4">(</span><span class="s0">b</span><span class="s4">);</span>
		<span class="s3">double </span><span class="s0">r </span><span class="s4">= </span><span class="s0">calcDistance</span><span class="s4">(</span><span class="s0">b</span><span class="s4">);</span>
		<span class="s3">double </span><span class="s0">dy </span><span class="s4">= </span><span class="s0">b</span><span class="s4">.</span><span class="s0">getY</span><span class="s4">() - </span><span class="s3">this</span><span class="s4">.</span><span class="s0">getY</span><span class="s4">();</span>
		<span class="s3">double </span><span class="s0">Fy </span><span class="s4">= </span><span class="s0">F </span><span class="s4">* </span><span class="s0">dy</span><span class="s4">/</span><span class="s0">r</span><span class="s4">;</span>
		<span class="s3">return </span><span class="s0">Fy</span><span class="s4">;</span>
	<span class="s4">}</span>

	<span class="s3">public double </span><span class="s0">calcNetForceExertedByX</span><span class="s4">(</span><span class="s0">CelestialBody</span><span class="s4">[] </span><span class="s0">bodies</span><span class="s4">) {</span>
		<span class="s5">// TODO: complete method</span>
		<span class="s3">double </span><span class="s0">sum </span><span class="s4">= </span><span class="s6">0.0</span><span class="s4">;</span>
		<span class="s3">for </span><span class="s4">(</span><span class="s3">int </span><span class="s0">i </span><span class="s4">= </span><span class="s6">0</span><span class="s4">; </span><span class="s0">i </span><span class="s4">&lt; </span><span class="s0">bodies</span><span class="s4">.</span><span class="s0">length</span><span class="s4">; </span><span class="s0">i</span><span class="s4">++) {</span>
			<span class="s0">CelestialBody b </span><span class="s4">= </span><span class="s0">bodies</span><span class="s4">[</span><span class="s0">i</span><span class="s4">];</span>
			<span class="s3">if </span><span class="s4">(</span><span class="s3">this </span><span class="s4">!= </span><span class="s0">b</span><span class="s4">) {</span>
				<span class="s0">sum </span><span class="s4">+= </span><span class="s0">calcForceExertedByX</span><span class="s4">(</span><span class="s0">b</span><span class="s4">);</span>
			<span class="s4">}</span>
		<span class="s4">}</span>
		<span class="s3">return </span><span class="s0">sum</span><span class="s4">;</span>
	<span class="s4">}</span>

	<span class="s3">public double </span><span class="s0">calcNetForceExertedByY</span><span class="s4">(</span><span class="s0">CelestialBody</span><span class="s4">[] </span><span class="s0">bodies</span><span class="s4">) {</span>
		<span class="s3">double </span><span class="s0">sum </span><span class="s4">= </span><span class="s6">0.0</span><span class="s4">;</span>
		<span class="s3">for </span><span class="s4">(</span><span class="s3">int </span><span class="s0">i </span><span class="s4">= </span><span class="s6">0</span><span class="s4">; </span><span class="s0">i </span><span class="s4">&lt; </span><span class="s0">bodies</span><span class="s4">.</span><span class="s0">length</span><span class="s4">; </span><span class="s0">i</span><span class="s4">++) {</span>
			<span class="s0">CelestialBody b </span><span class="s4">= </span><span class="s0">bodies</span><span class="s4">[</span><span class="s0">i</span><span class="s4">];</span>
			<span class="s3">if </span><span class="s4">(</span><span class="s3">this </span><span class="s4">!= </span><span class="s0">b</span><span class="s4">) {</span>
				<span class="s0">sum </span><span class="s4">+= </span><span class="s0">calcForceExertedByY</span><span class="s4">(</span><span class="s0">b</span><span class="s4">);</span>
			<span class="s4">}</span>
		<span class="s4">}</span>
		<span class="s3">return </span><span class="s0">sum</span><span class="s4">;</span>
	<span class="s4">}</span>

	<span class="s1">/**</span>
	 <span class="s1">* This is a mutator method, modifies state of a celestial body</span>
	 <span class="s1">* (position and velocity)</span>
	 <span class="s1">* </span><span class="s2">@param </span><span class="s1">deltaT the time-step used in updating</span>
	 <span class="s1">* </span><span class="s2">@param </span><span class="s1">xforce the force in the x-direction</span>
	 <span class="s1">* </span><span class="s2">@param </span><span class="s1">yforce the force in the y-direction</span>
	 <span class="s1">*/</span>
	<span class="s3">public void </span><span class="s0">update</span><span class="s4">(</span><span class="s3">double </span><span class="s0">deltaT</span><span class="s4">, </span>
			           <span class="s3">double </span><span class="s0">xforce</span><span class="s4">, </span><span class="s3">double </span><span class="s0">yforce</span><span class="s4">) {</span>
		<span class="s5">// TODO: complete method</span>
		<span class="s3">double </span><span class="s0">ax </span><span class="s4">= </span><span class="s0">xforce </span><span class="s4">/ </span><span class="s0">myMass</span><span class="s4">;</span>
		<span class="s3">double </span><span class="s0">ay </span><span class="s4">= </span><span class="s0">yforce </span><span class="s4">/ </span><span class="s0">myMass</span><span class="s4">;</span>
		<span class="s3">double </span><span class="s0">nvx </span><span class="s4">= </span><span class="s0">myXVel </span><span class="s4">+ </span><span class="s0">deltaT </span><span class="s4">* </span><span class="s0">ax</span><span class="s4">;</span>
		<span class="s3">double </span><span class="s0">nvy </span><span class="s4">= </span><span class="s0">myYVel </span><span class="s4">+ </span><span class="s0">deltaT </span><span class="s4">* </span><span class="s0">ay</span><span class="s4">;</span>
		<span class="s3">double </span><span class="s0">nx </span><span class="s4">= </span><span class="s0">myXPos </span><span class="s4">+ </span><span class="s0">deltaT </span><span class="s4">* </span><span class="s0">nvx</span><span class="s4">;</span>
		<span class="s3">double </span><span class="s0">ny </span><span class="s4">= </span><span class="s0">myYPos </span><span class="s4">+ </span><span class="s0">deltaT </span><span class="s4">* </span><span class="s0">nvy</span><span class="s4">;</span>
		<span class="s0">myXPos </span><span class="s4">= </span><span class="s0">nx</span><span class="s4">;</span>
		<span class="s0">myYPos </span><span class="s4">= </span><span class="s0">ny</span><span class="s4">;</span>
		<span class="s0">myXVel </span><span class="s4">= </span><span class="s0">nvx</span><span class="s4">;</span>
		<span class="s0">myYVel </span><span class="s4">= </span><span class="s0">nvy</span><span class="s4">;</span>
	<span class="s4">}</span>

	<span class="s1">/**</span>
	 <span class="s1">* Draws this planet's image at its current position</span>
	 <span class="s1">*/</span>
	<span class="s3">public void </span><span class="s0">draw</span><span class="s4">() {</span>
		<span class="s0">StdDraw</span><span class="s4">.</span><span class="s0">picture</span><span class="s4">(</span><span class="s0">myXPos</span><span class="s4">,</span><span class="s0">myYPos</span><span class="s4">,</span><span class="s7">&quot;images/&quot;</span><span class="s4">+</span><span class="s0">myFileName</span><span class="s4">);</span>
	<span class="s4">}</span>
<span class="s4">}</span>
</pre>
</body>
</html>