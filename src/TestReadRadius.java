<html>
<head>
<title>TestReadRadius.java</title>
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
TestReadRadius.java</font>
</center></td></tr></table>
<pre>

<span class="s1">import </span><span class="s0">java</span><span class="s2">.</span><span class="s0">io</span><span class="s2">.</span><span class="s0">FileNotFoundException</span><span class="s2">;</span>

<span class="s3">/**</span>
 <span class="s3">*  Tests Nbody.readRadius. Reads in ./data/planets.txt and checks to see that</span>
 <span class="s3">*  result matches hard coded value.</span>
 <span class="s3">*/</span>
<span class="s1">public class </span><span class="s0">TestReadRadius </span><span class="s2">{</span>

    <span class="s3">/**</span>
     <span class="s3">*  Checks whether or not two Doubles are equal and prints the result.</span>
     <span class="s3">*</span>
     <span class="s3">*  </span><span class="s4">@param  </span><span class="s3">expected    Expected double</span>
     <span class="s3">*  </span><span class="s4">@param  </span><span class="s3">actual      Double received</span>
     <span class="s3">*  </span><span class="s4">@param  </span><span class="s3">label   Label for the 'test' case</span>
     <span class="s3">*  </span><span class="s4">@param  </span><span class="s3">eps     Tolerance for the double comparison.</span>
     <span class="s3">*/</span>
    <span class="s1">private static void </span><span class="s0">checkEquals</span><span class="s2">(</span><span class="s1">double </span><span class="s0">actual</span><span class="s2">, </span><span class="s1">double </span><span class="s0">expected</span><span class="s2">, </span><span class="s0">String label</span><span class="s2">, </span><span class="s1">double </span><span class="s0">eps</span><span class="s2">) {</span>
        <span class="s1">if </span><span class="s2">(</span><span class="s0">Math</span><span class="s2">.</span><span class="s0">abs</span><span class="s2">(</span><span class="s0">expected </span><span class="s2">- </span><span class="s0">actual</span><span class="s2">) &lt;= </span><span class="s0">eps </span><span class="s2">* </span><span class="s0">Math</span><span class="s2">.</span><span class="s0">max</span><span class="s2">(</span><span class="s0">expected</span><span class="s2">, </span><span class="s0">actual</span><span class="s2">)) {</span>
            <span class="s0">System</span><span class="s2">.</span><span class="s0">out</span><span class="s2">.</span><span class="s0">println</span><span class="s2">(</span><span class="s5">&quot;PASS: &quot; </span><span class="s2">+ </span><span class="s0">label </span><span class="s2">+ </span><span class="s5">&quot;: Expected &quot; </span><span class="s2">+ </span><span class="s0">expected </span><span class="s2">+ </span><span class="s5">&quot; and you gave &quot; </span><span class="s2">+ </span><span class="s0">actual</span><span class="s2">);</span>
        <span class="s2">} </span><span class="s1">else </span><span class="s2">{</span>
            <span class="s0">System</span><span class="s2">.</span><span class="s0">out</span><span class="s2">.</span><span class="s0">println</span><span class="s2">(</span><span class="s5">&quot;FAIL: &quot; </span><span class="s2">+ </span><span class="s0">label </span><span class="s2">+ </span><span class="s5">&quot;: Expected &quot; </span><span class="s2">+ </span><span class="s0">expected </span><span class="s2">+ </span><span class="s5">&quot; and you gave &quot; </span><span class="s2">+ </span><span class="s0">actual</span><span class="s2">);</span>
        <span class="s2">}</span>
    <span class="s2">}</span>

    <span class="s3">/**</span>
     <span class="s3">*  Checks the NBody.readRadius() method.</span>
     <span class="s3">* </span><span class="s4">@throws </span><span class="s3">FileNotFoundException </span>
     <span class="s3">*/</span>
    <span class="s1">private static void </span><span class="s0">checkReadRadius</span><span class="s2">() </span><span class="s1">throws </span><span class="s0">FileNotFoundException </span><span class="s2">{</span>
        <span class="s0">System</span><span class="s2">.</span><span class="s0">out</span><span class="s2">.</span><span class="s0">println</span><span class="s2">(</span><span class="s5">&quot;Checking readRadius...&quot;</span><span class="s2">);</span>
        <span class="s0">String planetsTxtPath </span><span class="s2">= </span><span class="s5">&quot;./data/planets.txt&quot;</span><span class="s2">;</span>
        <span class="s6">/* If the following line fails to compile, you probably need to make 
         * a certain method static! */</span>
        <span class="s1">double </span><span class="s0">actualOutput </span><span class="s2">= </span><span class="s0">NBody</span><span class="s2">.</span><span class="s0">readRadius</span><span class="s2">(</span><span class="s0">planetsTxtPath</span><span class="s2">);</span>
        <span class="s0">checkEquals</span><span class="s2">(</span><span class="s0">actualOutput</span><span class="s2">, </span><span class="s7">2.50E11</span><span class="s2">, </span><span class="s5">&quot;readRadius()&quot;</span><span class="s2">, </span><span class="s7">0.01</span><span class="s2">);</span>
       
        
        <span class="s0">planetsTxtPath </span><span class="s2">= </span><span class="s5">&quot;./data/binaryStars.txt&quot;</span><span class="s2">;</span>
        <span class="s0">actualOutput </span><span class="s2">= </span><span class="s0">NBody</span><span class="s2">.</span><span class="s0">readRadius</span><span class="s2">(</span><span class="s0">planetsTxtPath</span><span class="s2">);</span>
        <span class="s0">checkEquals</span><span class="s2">(</span><span class="s0">actualOutput</span><span class="s2">, </span><span class="s7">3.00E11</span><span class="s2">, </span><span class="s5">&quot;readRadius()&quot;</span><span class="s2">, </span><span class="s7">0.01</span><span class="s2">);</span>
    <span class="s2">}</span>

    <span class="s1">public static void </span><span class="s0">main</span><span class="s2">(</span><span class="s0">String</span><span class="s2">[] </span><span class="s0">args</span><span class="s2">) </span><span class="s1">throws </span><span class="s0">FileNotFoundException </span><span class="s2">{</span>
        <span class="s0">checkReadRadius</span><span class="s2">();</span>
    <span class="s2">}</span>
<span class="s2">}</span>
</pre>
</body>
</html>