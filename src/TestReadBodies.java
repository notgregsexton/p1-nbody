<html>
<head>
<title>TestReadBodies.java</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style type="text/css">
.s0 { color: #bcbec4;}
.s1 { color: #cf8e6d;}
.s2 { color: #bcbec4;}
.s3 { color: #5f826b; font-style: italic;}
.s4 { color: #67a37c; font-style: italic;}
.s5 { color: #6aab73;}
.s6 { color: #7a7e85;}
.s7 { color: #2aacb8;}
</style>
</head>
<body bgcolor="#1e1f22">
<table CELLSPACING=0 CELLPADDING=5 COLS=1 WIDTH="100%" BGCOLOR="#606060" >
<tr><td><center>
<font face="Arial, Helvetica" color="#000000">
TestReadBodies.java</font>
</center></td></tr></table>
<pre>

<span class="s1">import </span><span class="s0">java</span><span class="s2">.</span><span class="s0">io</span><span class="s2">.</span><span class="s0">FileNotFoundException</span><span class="s2">;</span>

<span class="s3">/**</span>
 <span class="s3">*  Tests Nbody.readBodies. Reads in ./data/planets.txt and checks output of</span>
 <span class="s3">*  readBodies().</span>
 <span class="s3">*/</span>
<span class="s1">public class </span><span class="s0">TestReadBodies </span><span class="s2">{</span>

    <span class="s1">private static boolean </span><span class="s0">doubleEquals</span><span class="s2">(</span><span class="s1">double </span><span class="s0">actual</span><span class="s2">, </span><span class="s1">double </span><span class="s0">expected</span><span class="s2">, </span><span class="s1">double </span><span class="s0">eps</span><span class="s2">) {</span>
        <span class="s1">return </span><span class="s0">Math</span><span class="s2">.</span><span class="s0">abs</span><span class="s2">(</span><span class="s0">expected </span><span class="s2">- </span><span class="s0">actual</span><span class="s2">) &lt;= </span><span class="s0">eps </span><span class="s2">* </span><span class="s0">Math</span><span class="s2">.</span><span class="s0">max</span><span class="s2">(</span><span class="s0">expected</span><span class="s2">, </span><span class="s0">actual</span><span class="s2">);</span>
    <span class="s2">}</span>

    <span class="s3">/** Checks to make sure that readBodies() works perfectly. </span>
     <span class="s3">* </span><span class="s4">@throws </span><span class="s3">FileNotFoundException */</span>
    <span class="s1">private static </span><span class="s0">String checkReadBodies</span><span class="s2">() </span><span class="s1">throws </span><span class="s0">FileNotFoundException </span><span class="s2">{</span>
        <span class="s0">System</span><span class="s2">.</span><span class="s0">out</span><span class="s2">.</span><span class="s0">println</span><span class="s2">(</span><span class="s5">&quot;Checking readBodies...&quot;</span><span class="s2">);</span>
        <span class="s0">String planetsTxtPath </span><span class="s2">= </span><span class="s5">&quot;./data/planets.txt&quot;</span><span class="s2">;</span>
        <span class="s6">/* If the following line fails to compile, you probably need to make 
         * a certain method static! */</span>
        <span class="s0">CelestialBody</span><span class="s2">[] </span><span class="s0">actualOutput </span><span class="s2">= </span><span class="s0">NBody</span><span class="s2">.</span><span class="s0">readBodies</span><span class="s2">(</span><span class="s0">planetsTxtPath</span><span class="s2">);</span>

        <span class="s6">/* Check the simple things: */</span>
        <span class="s1">if </span><span class="s2">(</span><span class="s0">actualOutput </span><span class="s2">== </span><span class="s1">null</span><span class="s2">) {</span>
            <span class="s1">return </span><span class="s5">&quot;FAIL: readBodies(); null output&quot;</span><span class="s2">;</span>
        <span class="s2">}</span>
        <span class="s1">if </span><span class="s2">(</span><span class="s0">actualOutput</span><span class="s2">.</span><span class="s0">length </span><span class="s2">!= </span><span class="s7">5</span><span class="s2">) {</span>
            <span class="s1">return </span><span class="s5">&quot;FAIL: readBodies().length: Expected 5 and you gave &quot; </span><span class="s2">+ </span><span class="s0">actualOutput</span><span class="s2">.</span><span class="s0">length</span><span class="s2">;</span>
        <span class="s2">}</span>

        <span class="s6">/* Check to make sure every body exists, plus random spot checks */</span>
        <span class="s1">boolean </span><span class="s0">foundEarth </span><span class="s2">= </span><span class="s1">false</span><span class="s2">;</span>
        <span class="s1">boolean </span><span class="s0">foundMars </span><span class="s2">= </span><span class="s1">false</span><span class="s2">;</span>
        <span class="s1">boolean </span><span class="s0">foundMercury </span><span class="s2">= </span><span class="s1">false</span><span class="s2">;</span>
        <span class="s1">boolean </span><span class="s0">foundSun </span><span class="s2">= </span><span class="s1">false</span><span class="s2">;</span>
        <span class="s1">boolean </span><span class="s0">foundVenus </span><span class="s2">= </span><span class="s1">false</span><span class="s2">;</span>
        <span class="s1">boolean </span><span class="s0">randomChecksOkay </span><span class="s2">= </span><span class="s1">true</span><span class="s2">;</span>
        <span class="s1">for </span><span class="s2">(</span><span class="s0">CelestialBody p </span><span class="s2">: </span><span class="s0">actualOutput</span><span class="s2">) {</span>
            <span class="s1">if </span><span class="s2">(</span><span class="s5">&quot;earth.gif&quot;</span><span class="s2">.</span><span class="s0">equals</span><span class="s2">(</span><span class="s0">p</span><span class="s2">.</span><span class="s0">getName</span><span class="s2">())) {</span>
                <span class="s0">foundEarth </span><span class="s2">= </span><span class="s1">true</span><span class="s2">;</span>
                <span class="s1">if </span><span class="s2">(!</span><span class="s0">doubleEquals</span><span class="s2">(</span><span class="s0">p</span><span class="s2">.</span><span class="s0">getX</span><span class="s2">(), </span><span class="s7">1.4960e+11</span><span class="s2">, </span><span class="s7">0.01</span><span class="s2">)) {</span>
                    <span class="s0">System</span><span class="s2">.</span><span class="s0">out</span><span class="s2">.</span><span class="s0">println</span><span class="s2">(</span><span class="s5">&quot;Advice: Your Earth doesn't have the right xxPos!&quot;</span><span class="s2">);</span>
                    <span class="s0">randomChecksOkay </span><span class="s2">= </span><span class="s1">false</span><span class="s2">;</span>
                <span class="s2">}</span>
            <span class="s2">} </span><span class="s1">else if </span><span class="s2">(</span><span class="s5">&quot;mars.gif&quot;</span><span class="s2">.</span><span class="s0">equals</span><span class="s2">(</span><span class="s0">p</span><span class="s2">.</span><span class="s0">getName</span><span class="s2">())) {</span>
                <span class="s0">foundMars </span><span class="s2">= </span><span class="s1">true</span><span class="s2">;</span>
            <span class="s2">} </span><span class="s1">else if </span><span class="s2">(</span><span class="s5">&quot;mercury.gif&quot;</span><span class="s2">.</span><span class="s0">equals</span><span class="s2">(</span><span class="s0">p</span><span class="s2">.</span><span class="s0">getName</span><span class="s2">())) {</span>
                <span class="s0">foundMercury </span><span class="s2">= </span><span class="s1">true</span><span class="s2">;</span>
                <span class="s1">if </span><span class="s2">(!</span><span class="s0">doubleEquals</span><span class="s2">(</span><span class="s0">p</span><span class="s2">.</span><span class="s0">getY</span><span class="s2">(), </span><span class="s7">0</span><span class="s2">, </span><span class="s7">0.01</span><span class="s2">)) {</span>
                    <span class="s0">System</span><span class="s2">.</span><span class="s0">out</span><span class="s2">.</span><span class="s0">println</span><span class="s2">(</span><span class="s5">&quot;Advice: Your Mercury doesn't have the right yyPos!&quot;</span><span class="s2">);</span>
                    <span class="s0">randomChecksOkay </span><span class="s2">= </span><span class="s1">false</span><span class="s2">;</span>
                <span class="s2">}</span>
            <span class="s2">} </span><span class="s1">else if </span><span class="s2">(</span><span class="s5">&quot;sun.gif&quot;</span><span class="s2">.</span><span class="s0">equals</span><span class="s2">(</span><span class="s0">p</span><span class="s2">.</span><span class="s0">getName</span><span class="s2">())) {</span>
                <span class="s0">foundSun </span><span class="s2">= </span><span class="s1">true</span><span class="s2">;</span>
            <span class="s2">} </span><span class="s1">else if </span><span class="s2">(</span><span class="s5">&quot;venus.gif&quot;</span><span class="s2">.</span><span class="s0">equals</span><span class="s2">(</span><span class="s0">p</span><span class="s2">.</span><span class="s0">getName</span><span class="s2">())) {</span>
                <span class="s0">foundVenus </span><span class="s2">= </span><span class="s1">true</span><span class="s2">;</span>
                <span class="s1">if </span><span class="s2">(!</span><span class="s0">doubleEquals</span><span class="s2">(</span><span class="s0">p</span><span class="s2">.</span><span class="s0">getMass</span><span class="s2">(), </span><span class="s7">4.8690e+24</span><span class="s2">, </span><span class="s7">0.01</span><span class="s2">)) {</span>
                    <span class="s0">System</span><span class="s2">.</span><span class="s0">out</span><span class="s2">.</span><span class="s0">println</span><span class="s2">(</span><span class="s5">&quot;Advice: Your Venus doesn't have the right mass!&quot;</span><span class="s2">);</span>
                    <span class="s0">randomChecksOkay </span><span class="s2">= </span><span class="s1">false</span><span class="s2">;</span>
                <span class="s2">}</span>
            <span class="s2">}</span>
            <span class="s1">else </span><span class="s2">{</span>
                <span class="s0">System</span><span class="s2">.</span><span class="s0">out</span><span class="s2">.</span><span class="s0">printf</span><span class="s2">(</span><span class="s5">&quot;unexpected planet file: '%s'</span><span class="s1">\n</span><span class="s5">&quot;</span><span class="s2">,</span><span class="s0">p</span><span class="s2">.</span><span class="s0">getName</span><span class="s2">());</span>
            <span class="s2">}</span>
        <span class="s2">}</span>

        <span class="s6">/* Build up a nice list of missing bodies */</span>
        <span class="s0">String missingBodies </span><span class="s2">= </span><span class="s5">&quot;&quot;</span><span class="s2">;</span>
        <span class="s1">if </span><span class="s2">(!</span><span class="s0">foundEarth</span><span class="s2">) {</span>
            <span class="s0">missingBodies </span><span class="s2">+= </span><span class="s5">&quot;Earth, &quot;</span><span class="s2">;</span>
        <span class="s2">}</span>
        <span class="s1">if </span><span class="s2">(!</span><span class="s0">foundMars</span><span class="s2">) {</span>
            <span class="s0">missingBodies </span><span class="s2">+= </span><span class="s5">&quot;Mars, &quot;</span><span class="s2">;</span>
        <span class="s2">}</span>
        <span class="s1">if </span><span class="s2">(!</span><span class="s0">foundMercury</span><span class="s2">) {</span>
            <span class="s0">missingBodies </span><span class="s2">+= </span><span class="s5">&quot;Mercury, &quot;</span><span class="s2">;</span>
        <span class="s2">}</span>
        <span class="s1">if </span><span class="s2">(!</span><span class="s0">foundSun</span><span class="s2">) {</span>
            <span class="s0">missingBodies </span><span class="s2">+= </span><span class="s5">&quot;Sun, &quot;</span><span class="s2">;</span>
        <span class="s2">}</span>
        <span class="s1">if </span><span class="s2">(!</span><span class="s0">foundVenus</span><span class="s2">) {</span>
            <span class="s0">missingBodies </span><span class="s2">+= </span><span class="s5">&quot;Venus, &quot;</span><span class="s2">;</span>
        <span class="s2">}</span>
        <span class="s1">if </span><span class="s2">(</span><span class="s0">missingBodies</span><span class="s2">.</span><span class="s0">length</span><span class="s2">() &gt; </span><span class="s7">0</span><span class="s2">) {</span>
            <span class="s0">String answer </span><span class="s2">= </span><span class="s5">&quot;FAIL: readBodies(); Missing these bodies: &quot;</span><span class="s2">;</span>
            <span class="s0">answer </span><span class="s2">+= </span><span class="s0">missingBodies</span><span class="s2">.</span><span class="s0">substring</span><span class="s2">(</span><span class="s7">0</span><span class="s2">, </span><span class="s0">missingBodies</span><span class="s2">.</span><span class="s0">length</span><span class="s2">() - </span><span class="s7">2</span><span class="s2">);</span>
            <span class="s1">return </span><span class="s0">answer</span><span class="s2">;</span>
        <span class="s2">}</span>
        <span class="s1">if </span><span class="s2">(!</span><span class="s0">randomChecksOkay</span><span class="s2">) {</span>
            <span class="s1">return </span><span class="s5">&quot;FAIL: readBodies(); Not all bodies have correct info!&quot;</span><span class="s2">;</span>
        <span class="s2">}</span>
        <span class="s1">return </span><span class="s5">&quot;PASS: readBodies(); Congrats! This was the hardest test!&quot;</span><span class="s2">;</span>
    <span class="s2">}</span>

    <span class="s1">public static void </span><span class="s0">main</span><span class="s2">(</span><span class="s0">String</span><span class="s2">[] </span><span class="s0">args</span><span class="s2">) </span><span class="s1">throws </span><span class="s0">FileNotFoundException </span><span class="s2">{</span>
        <span class="s0">String testResult </span><span class="s2">= </span><span class="s0">checkReadBodies</span><span class="s2">();</span>
        <span class="s0">System</span><span class="s2">.</span><span class="s0">out</span><span class="s2">.</span><span class="s0">println</span><span class="s2">(</span><span class="s0">testResult</span><span class="s2">);</span>
    <span class="s2">}</span>
<span class="s2">}</span>
</pre>
</body>
</html>