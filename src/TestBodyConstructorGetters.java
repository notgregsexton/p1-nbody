<html>
<head>
<title>TestBodyConstructorGetters.java</title>
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
TestBodyConstructorGetters.java</font>
</center></td></tr></table>
<pre>

<span class="s1">/**</span>
 <span class="s1">*  Tests the Body constructor.</span>
 <span class="s1">*/</span>
<span class="s2">public class </span><span class="s0">TestBodyConstructorGetters </span><span class="s3">{</span>

    <span class="s1">/**</span>
     <span class="s1">*  Tests the Body constructor to make sure it's working correctly.</span>
     <span class="s1">*/</span>
    <span class="s2">public static void </span><span class="s0">main</span><span class="s3">(</span><span class="s0">String</span><span class="s3">[] </span><span class="s0">args</span><span class="s3">) {</span>
        <span class="s0">checkBodyConstructor</span><span class="s3">();</span>
    <span class="s3">}</span>

    <span class="s1">/**</span>
     <span class="s1">*  Checks whether or not two Doubles are equal and prints the result.</span>
     <span class="s1">*</span>
     <span class="s1">*  </span><span class="s4">@param  </span><span class="s1">expected    Expected double</span>
     <span class="s1">*  </span><span class="s4">@param  </span><span class="s1">actual      Double received</span>
     <span class="s1">*  </span><span class="s4">@param  </span><span class="s1">label   Label for the 'test' case</span>
     <span class="s1">*/</span>
    <span class="s2">private static void </span><span class="s0">checkEquals</span><span class="s3">(</span><span class="s2">double </span><span class="s0">expected</span><span class="s3">, </span><span class="s2">double </span><span class="s0">actual</span><span class="s3">, </span><span class="s0">String label</span><span class="s3">) {</span>
        <span class="s2">if </span><span class="s3">(</span><span class="s0">expected </span><span class="s3">== </span><span class="s0">actual</span><span class="s3">) {</span>
            <span class="s0">System</span><span class="s3">.</span><span class="s0">out</span><span class="s3">.</span><span class="s0">println</span><span class="s3">(</span><span class="s5">&quot;PASS: &quot; </span><span class="s3">+ </span><span class="s0">label </span><span class="s3">+ </span><span class="s5">&quot;: Expected &quot; </span><span class="s3">+ </span><span class="s0">expected </span><span class="s3">+ </span><span class="s5">&quot; and you gave &quot; </span><span class="s3">+ </span><span class="s0">actual</span><span class="s3">);</span>
        <span class="s3">} </span><span class="s2">else </span><span class="s3">{</span>
            <span class="s0">System</span><span class="s3">.</span><span class="s0">out</span><span class="s3">.</span><span class="s0">println</span><span class="s3">(</span><span class="s5">&quot;FAIL: &quot; </span><span class="s3">+ </span><span class="s0">label </span><span class="s3">+ </span><span class="s5">&quot;: Expected &quot; </span><span class="s3">+ </span><span class="s0">expected </span><span class="s3">+ </span><span class="s5">&quot; and you gave &quot; </span><span class="s3">+ </span><span class="s0">actual</span><span class="s3">);</span>
        <span class="s3">}</span>
    <span class="s3">}</span>

    <span class="s1">/**</span>
     <span class="s1">*  Checks whether or not two Strings are equal and prints the result.</span>
     <span class="s1">*  </span><span class="s4">@param  </span><span class="s1">expected    Expected String</span>
     <span class="s1">*  </span><span class="s4">@param  </span><span class="s1">actual      String received</span>
     <span class="s1">*  </span><span class="s4">@param  </span><span class="s1">label   Label for the 'test' case</span>
     <span class="s1">*/</span>
    <span class="s2">private static void </span><span class="s0">checkStringEquals</span><span class="s3">(</span><span class="s0">String expected</span><span class="s3">, </span><span class="s0">String actual</span><span class="s3">, </span><span class="s0">String label</span><span class="s3">) {</span>
        <span class="s2">if </span><span class="s3">(</span><span class="s0">expected</span><span class="s3">.</span><span class="s0">equals</span><span class="s3">(</span><span class="s0">actual</span><span class="s3">)) {</span>
            <span class="s0">System</span><span class="s3">.</span><span class="s0">out</span><span class="s3">.</span><span class="s0">println</span><span class="s3">(</span><span class="s5">&quot;PASS: &quot; </span><span class="s3">+ </span><span class="s0">label </span><span class="s3">+ </span><span class="s5">&quot;: Expected &quot; </span><span class="s3">+ </span><span class="s0">expected </span><span class="s3">+ </span><span class="s5">&quot; and you gave &quot; </span><span class="s3">+ </span><span class="s0">actual</span><span class="s3">);</span>
        <span class="s3">} </span><span class="s2">else </span><span class="s3">{</span>
            <span class="s0">System</span><span class="s3">.</span><span class="s0">out</span><span class="s3">.</span><span class="s0">println</span><span class="s3">(</span><span class="s5">&quot;FAIL: &quot; </span><span class="s3">+ </span><span class="s0">label </span><span class="s3">+ </span><span class="s5">&quot;: Expected &quot; </span><span class="s3">+ </span><span class="s0">expected </span><span class="s3">+ </span><span class="s5">&quot; and you gave &quot; </span><span class="s3">+ </span><span class="s0">actual</span><span class="s3">);</span>
        <span class="s3">}</span>
    <span class="s3">}</span>

    <span class="s1">/**</span>
     <span class="s1">*  Checks Body constructors to make sure they are setting instance</span>
     <span class="s1">*  variables correctly.</span>
     <span class="s1">*/</span>
    <span class="s2">private static void </span><span class="s0">checkBodyConstructor</span><span class="s3">() {</span>
        <span class="s0">System</span><span class="s3">.</span><span class="s0">out</span><span class="s3">.</span><span class="s0">println</span><span class="s3">(</span><span class="s5">&quot;Checking Body constructor and getters...&quot;</span><span class="s3">);</span>

        <span class="s2">double </span><span class="s0">xxPos </span><span class="s3">= </span><span class="s6">1.0</span><span class="s3">,</span>
               <span class="s0">yyPos </span><span class="s3">= </span><span class="s6">2.0</span><span class="s3">,</span>
               <span class="s0">xxVel </span><span class="s3">= </span><span class="s6">3.0</span><span class="s3">,</span>
               <span class="s0">yyVel </span><span class="s3">= </span><span class="s6">4.0</span><span class="s3">,</span>
               <span class="s0">mass </span><span class="s3">= </span><span class="s6">5.0</span><span class="s3">;</span>

        <span class="s0">String imgFileName </span><span class="s3">= </span><span class="s5">&quot;jupiter.gif&quot;</span><span class="s3">;</span>

        <span class="s0">CelestialBody p </span><span class="s3">= </span><span class="s2">new </span><span class="s0">CelestialBody</span><span class="s3">(</span><span class="s0">xxPos</span><span class="s3">, </span><span class="s0">yyPos</span><span class="s3">, </span><span class="s0">xxVel</span><span class="s3">, </span><span class="s0">yyVel</span><span class="s3">, </span><span class="s0">mass</span><span class="s3">, </span><span class="s0">imgFileName</span><span class="s3">);</span>

        <span class="s0">checkEquals</span><span class="s3">(</span><span class="s0">xxPos</span><span class="s3">, </span><span class="s0">p</span><span class="s3">.</span><span class="s0">getX</span><span class="s3">(), </span><span class="s5">&quot;x&quot;</span><span class="s3">);</span>
        <span class="s0">checkEquals</span><span class="s3">(</span><span class="s0">yyPos</span><span class="s3">, </span><span class="s0">p</span><span class="s3">.</span><span class="s0">getY</span><span class="s3">(), </span><span class="s5">&quot;y&quot;</span><span class="s3">);</span>
        <span class="s0">checkEquals</span><span class="s3">(</span><span class="s0">xxVel </span><span class="s3">,</span><span class="s0">p</span><span class="s3">.</span><span class="s0">getXVel</span><span class="s3">(), </span><span class="s5">&quot;xVelocity&quot;</span><span class="s3">);</span>
        <span class="s0">checkEquals</span><span class="s3">(</span><span class="s0">yyVel</span><span class="s3">, </span><span class="s0">p</span><span class="s3">.</span><span class="s0">getYVel</span><span class="s3">(), </span><span class="s5">&quot;yVelocity&quot;</span><span class="s3">);</span>
        <span class="s0">checkEquals</span><span class="s3">(</span><span class="s0">mass</span><span class="s3">, </span><span class="s0">p</span><span class="s3">.</span><span class="s0">getMass</span><span class="s3">(), </span><span class="s5">&quot;mass&quot;</span><span class="s3">);</span>
        <span class="s0">checkStringEquals</span><span class="s3">(</span><span class="s0">imgFileName</span><span class="s3">, </span><span class="s0">p</span><span class="s3">.</span><span class="s0">getName</span><span class="s3">(), </span><span class="s5">&quot;path to image&quot;</span><span class="s3">);</span>
    <span class="s3">}</span>
<span class="s3">}</span>
</pre>
</body>
</html>