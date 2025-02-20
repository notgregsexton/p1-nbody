<html>
<head>
<title>TestCalcDistance.java</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style type="text/css">
.s0 { color: #bcbec4;}
.s1 { color: #5f826b; font-style: italic;}
.s2 { color: #cf8e6d;}
.s3 { color: #bcbec4;}
.s4 { color: #67a37c; font-style: italic;}
.s5 { color: #6aab73;}
.s6 { color: #2aacb8;}
</style>
</head>
<body bgcolor="#1e1f22">
<table CELLSPACING=0 CELLPADDING=5 COLS=1 WIDTH="100%" BGCOLOR="#606060" >
<tr><td><center>
<font face="Arial, Helvetica" color="#000000">
TestCalcDistance.java</font>
</center></td></tr></table>
<pre>


<span class="s1">/**</span>
 <span class="s1">*  Tests calcDistance</span>
 <span class="s1">*/</span>
<span class="s2">public class </span><span class="s0">TestCalcDistance </span><span class="s3">{</span>

    <span class="s1">/**</span>
     <span class="s1">*  Tests calcDistance.</span>
     <span class="s1">*/</span>
    <span class="s2">public static void </span><span class="s0">main</span><span class="s3">(</span><span class="s0">String</span><span class="s3">[] </span><span class="s0">args</span><span class="s3">) {</span>
        <span class="s0">checkCalcDistance</span><span class="s3">();</span>
    <span class="s3">}</span>

    <span class="s1">/**</span>
     <span class="s1">*  Checks whether or not two Doubles are equal and prints the result.</span>
     <span class="s1">*</span>
     <span class="s1">*  </span><span class="s4">@param  </span><span class="s1">expected    Expected double</span>
     <span class="s1">*  </span><span class="s4">@param  </span><span class="s1">actual      Double received</span>
     <span class="s1">*  </span><span class="s4">@param  </span><span class="s1">label   Label for the 'test' case</span>
     <span class="s1">*  </span><span class="s4">@param  </span><span class="s1">eps     Tolerance for the double comparison.</span>
     <span class="s1">*/</span>
    <span class="s2">private static void </span><span class="s0">checkEquals</span><span class="s3">(</span><span class="s2">double </span><span class="s0">actual</span><span class="s3">, </span><span class="s2">double </span><span class="s0">expected</span><span class="s3">, </span><span class="s0">String label</span><span class="s3">, </span><span class="s2">double </span><span class="s0">eps</span><span class="s3">) {</span>
        <span class="s2">if </span><span class="s3">(</span><span class="s0">Math</span><span class="s3">.</span><span class="s0">abs</span><span class="s3">(</span><span class="s0">expected </span><span class="s3">- </span><span class="s0">actual</span><span class="s3">) &lt;= </span><span class="s0">eps </span><span class="s3">* </span><span class="s0">Math</span><span class="s3">.</span><span class="s0">max</span><span class="s3">(</span><span class="s0">expected</span><span class="s3">, </span><span class="s0">actual</span><span class="s3">)) {</span>
            <span class="s0">System</span><span class="s3">.</span><span class="s0">out</span><span class="s3">.</span><span class="s0">println</span><span class="s3">(</span><span class="s5">&quot;PASS: &quot; </span><span class="s3">+ </span><span class="s0">label </span><span class="s3">+ </span><span class="s5">&quot;: Expected &quot; </span><span class="s3">+ </span><span class="s0">expected </span><span class="s3">+ </span><span class="s5">&quot; and you gave &quot; </span><span class="s3">+ </span><span class="s0">actual</span><span class="s3">);</span>
        <span class="s3">} </span><span class="s2">else </span><span class="s3">{</span>
            <span class="s0">System</span><span class="s3">.</span><span class="s0">out</span><span class="s3">.</span><span class="s0">println</span><span class="s3">(</span><span class="s5">&quot;FAIL: &quot; </span><span class="s3">+ </span><span class="s0">label </span><span class="s3">+ </span><span class="s5">&quot;: Expected &quot; </span><span class="s3">+ </span><span class="s0">expected </span><span class="s3">+ </span><span class="s5">&quot; and you gave &quot; </span><span class="s3">+ </span><span class="s0">actual</span><span class="s3">);</span>
        <span class="s3">}</span>
    <span class="s3">}</span>

    <span class="s1">/**</span>
     <span class="s1">*  Checks the Body class to make sure calcDistance works.</span>
     <span class="s1">*/</span>
    <span class="s2">private static void </span><span class="s0">checkCalcDistance</span><span class="s3">() {</span>
        <span class="s0">System</span><span class="s3">.</span><span class="s0">out</span><span class="s3">.</span><span class="s0">println</span><span class="s3">(</span><span class="s5">&quot;Checking calcDistance...&quot;</span><span class="s3">);</span>

        <span class="s0">CelestialBody p1 </span><span class="s3">= </span><span class="s2">new </span><span class="s0">CelestialBody</span><span class="s3">(</span><span class="s6">1.0</span><span class="s3">, </span><span class="s6">1.0</span><span class="s3">, </span><span class="s6">3.0</span><span class="s3">, </span><span class="s6">4.0</span><span class="s3">, </span><span class="s6">5.0</span><span class="s3">, </span><span class="s5">&quot;jupiter.gif&quot;</span><span class="s3">);</span>
        <span class="s0">CelestialBody p2 </span><span class="s3">= </span><span class="s2">new </span><span class="s0">CelestialBody</span><span class="s3">(</span><span class="s6">2.0</span><span class="s3">, </span><span class="s6">1.0</span><span class="s3">, </span><span class="s6">3.0</span><span class="s3">, </span><span class="s6">4.0</span><span class="s3">, </span><span class="s6">5.0</span><span class="s3">, </span><span class="s5">&quot;jupiter.gif&quot;</span><span class="s3">);</span>
        <span class="s0">CelestialBody p3 </span><span class="s3">= </span><span class="s2">new </span><span class="s0">CelestialBody</span><span class="s3">(</span><span class="s6">4.0</span><span class="s3">, </span><span class="s6">5.0</span><span class="s3">, </span><span class="s6">3.0</span><span class="s3">, </span><span class="s6">4.0</span><span class="s3">, </span><span class="s6">5.0</span><span class="s3">, </span><span class="s5">&quot;jupiter.gif&quot;</span><span class="s3">);</span>

        <span class="s0">checkEquals</span><span class="s3">(</span><span class="s0">p1</span><span class="s3">.</span><span class="s0">calcDistance</span><span class="s3">(</span><span class="s0">p2</span><span class="s3">), </span><span class="s6">1.0</span><span class="s3">, </span><span class="s5">&quot;calcDistance()&quot;</span><span class="s3">, </span><span class="s6">0.01</span><span class="s3">);</span>
        <span class="s0">checkEquals</span><span class="s3">(</span><span class="s0">p1</span><span class="s3">.</span><span class="s0">calcDistance</span><span class="s3">(</span><span class="s0">p3</span><span class="s3">), </span><span class="s6">5.0</span><span class="s3">, </span><span class="s5">&quot;calcDistance()&quot;</span><span class="s3">, </span><span class="s6">0.01</span><span class="s3">);</span>
    <span class="s3">}</span>
<span class="s3">}</span>
</pre>
</body>
</html>