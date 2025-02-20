<html>
<head>
<title>TestCalcForceExertedBy.java</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style type="text/css">
.s0 { color: #bcbec4;}
.s1 { color: #cf8e6d;}
.s2 { color: #bcbec4;}
.s3 { color: #5f826b; font-style: italic;}
.s4 { color: #67a37c; font-style: italic;}
.s5 { color: #6aab73;}
.s6 { color: #2aacb8;}
</style>
</head>
<body bgcolor="#1e1f22">
<table CELLSPACING=0 CELLPADDING=5 COLS=1 WIDTH="100%" BGCOLOR="#606060" >
<tr><td><center>
<font face="Arial, Helvetica" color="#000000">
TestCalcForceExertedBy.java</font>
</center></td></tr></table>
<pre>

<span class="s1">import </span><span class="s0">java</span><span class="s2">.</span><span class="s0">math</span><span class="s2">.*;</span>

<span class="s3">/**</span>
 <span class="s3">*  Tests calcForceExertedBy</span>
 <span class="s3">*/</span>
<span class="s1">public class </span><span class="s0">TestCalcForceExertedBy </span><span class="s2">{</span>

    <span class="s3">/**</span>
     <span class="s3">*  Tests calcForceExertedBy.</span>
     <span class="s3">*/</span>
    <span class="s1">public static void </span><span class="s0">main</span><span class="s2">(</span><span class="s0">String</span><span class="s2">[] </span><span class="s0">args</span><span class="s2">) {</span>
        <span class="s0">checkCalcForceExertedBy</span><span class="s2">();</span>
    <span class="s2">}</span>

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
     <span class="s3">*  Checks the Body class to make sure calcForceExertedBy works.</span>
     <span class="s3">*/</span>
    <span class="s1">private static void </span><span class="s0">checkCalcForceExertedBy</span><span class="s2">() {</span>
        <span class="s0">System</span><span class="s2">.</span><span class="s0">out</span><span class="s2">.</span><span class="s0">println</span><span class="s2">(</span><span class="s5">&quot;Checking calcForceExertedBy...&quot;</span><span class="s2">);</span>

        <span class="s0">CelestialBody p1 </span><span class="s2">= </span><span class="s1">new </span><span class="s0">CelestialBody</span><span class="s2">(</span><span class="s6">1.0</span><span class="s2">, </span><span class="s6">1.0</span><span class="s2">, </span><span class="s6">3.0</span><span class="s2">, </span><span class="s6">4.0</span><span class="s2">, </span><span class="s6">5.0</span><span class="s2">, </span><span class="s5">&quot;jupiter.gif&quot;</span><span class="s2">);</span>
        <span class="s0">CelestialBody p2 </span><span class="s2">= </span><span class="s1">new </span><span class="s0">CelestialBody</span><span class="s2">(</span><span class="s6">2.0</span><span class="s2">, </span><span class="s6">1.0</span><span class="s2">, </span><span class="s6">3.0</span><span class="s2">, </span><span class="s6">4.0</span><span class="s2">, </span><span class="s6">4e11</span><span class="s2">, </span><span class="s5">&quot;jupiter.gif&quot;</span><span class="s2">);</span>
        <span class="s0">CelestialBody p3 </span><span class="s2">= </span><span class="s1">new </span><span class="s0">CelestialBody</span><span class="s2">(</span><span class="s6">4.0</span><span class="s2">, </span><span class="s6">5.0</span><span class="s2">, </span><span class="s6">3.0</span><span class="s2">, </span><span class="s6">4.0</span><span class="s2">, </span><span class="s6">5.0</span><span class="s2">, </span><span class="s5">&quot;jupiter.gif&quot;</span><span class="s2">);</span>

        <span class="s0">checkEquals</span><span class="s2">(</span><span class="s0">p1</span><span class="s2">.</span><span class="s0">calcForceExertedBy</span><span class="s2">(</span><span class="s0">p2</span><span class="s2">), </span><span class="s6">133.4</span><span class="s2">, </span><span class="s5">&quot;calcForceExertedBy()&quot;</span><span class="s2">, </span><span class="s6">0.01</span><span class="s2">);</span>
        <span class="s0">checkEquals</span><span class="s2">(</span><span class="s0">p1</span><span class="s2">.</span><span class="s0">calcForceExertedBy</span><span class="s2">(</span><span class="s0">p3</span><span class="s2">), </span><span class="s6">6.67e-11</span><span class="s2">, </span><span class="s5">&quot;calcForceExertedBy()&quot;</span><span class="s2">, </span><span class="s6">0.01</span><span class="s2">);</span>
    <span class="s2">}</span>
<span class="s2">}</span>
</pre>
</body>
</html>