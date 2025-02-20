<html>
<head>
<title>TestCalcForceExertedByXY.java</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style type="text/css">
.s0 { color: #cf8e6d;}
.s1 { color: #bcbec4;}
.s2 { color: #bcbec4;}
.s3 { color: #5f826b; font-style: italic;}
.s4 { color: #67a37c; font-style: italic;}
.s5 { color: #6aab73;}
.s6 { color: #2aacb8;}
.s7 { color: #7a7e85;}
</style>
</head>
<body bgcolor="#1e1f22">
<table CELLSPACING=0 CELLPADDING=5 COLS=1 WIDTH="100%" BGCOLOR="#606060" >
<tr><td><center>
<font face="Arial, Helvetica" color="#000000">
TestCalcForceExertedByXY.java</font>
</center></td></tr></table>
<pre><span class="s0">import </span><span class="s1">java</span><span class="s2">.</span><span class="s1">math</span><span class="s2">.*;</span>

<span class="s3">/**</span>
 <span class="s3">*  Tests calcPairwiseForce</span>
 <span class="s3">*/</span>
<span class="s0">public class </span><span class="s1">TestCalcForceExertedByXY </span><span class="s2">{</span>

    <span class="s3">/**</span>
     <span class="s3">*  Tests calcForceExertedByXY.</span>
     <span class="s3">*/</span>
    <span class="s0">public static void </span><span class="s1">main</span><span class="s2">(</span><span class="s1">String</span><span class="s2">[] </span><span class="s1">args</span><span class="s2">) {</span>
        <span class="s1">checkCalcForceExertedByXY</span><span class="s2">();</span>
    <span class="s2">}</span>

    <span class="s3">/**</span>
     <span class="s3">*  Checks whether or not two Doubles are equal and prints the result.</span>
     <span class="s3">*</span>
     <span class="s3">*  </span><span class="s4">@param  </span><span class="s3">expected    Expected double</span>
     <span class="s3">*  </span><span class="s4">@param  </span><span class="s3">actual      Double received</span>
     <span class="s3">*  </span><span class="s4">@param  </span><span class="s3">label   Label for the 'test' case</span>
     <span class="s3">*  </span><span class="s4">@param  </span><span class="s3">eps     Tolerance for the double comparison.</span>
     <span class="s3">*/</span>
    <span class="s0">private static void </span><span class="s1">checkEquals</span><span class="s2">(</span><span class="s0">double </span><span class="s1">actual</span><span class="s2">, </span><span class="s0">double </span><span class="s1">expected</span><span class="s2">, </span><span class="s1">String label</span><span class="s2">, </span><span class="s0">double </span><span class="s1">eps</span><span class="s2">) {</span>
        <span class="s0">if </span><span class="s2">(</span><span class="s1">Math</span><span class="s2">.</span><span class="s1">abs</span><span class="s2">(</span><span class="s1">expected </span><span class="s2">- </span><span class="s1">actual</span><span class="s2">) &lt;= </span><span class="s1">eps </span><span class="s2">* </span><span class="s1">Math</span><span class="s2">.</span><span class="s1">abs</span><span class="s2">(</span><span class="s1">Math</span><span class="s2">.</span><span class="s1">max</span><span class="s2">(</span><span class="s1">expected</span><span class="s2">, </span><span class="s1">actual</span><span class="s2">))) {</span>
            <span class="s1">System</span><span class="s2">.</span><span class="s1">out</span><span class="s2">.</span><span class="s1">println</span><span class="s2">(</span><span class="s5">&quot;PASS: &quot; </span><span class="s2">+ </span><span class="s1">label </span><span class="s2">+ </span><span class="s5">&quot;: Expected &quot; </span><span class="s2">+ </span><span class="s1">expected </span><span class="s2">+ </span><span class="s5">&quot; and you gave &quot; </span><span class="s2">+ </span><span class="s1">actual</span><span class="s2">);</span>
        <span class="s2">} </span><span class="s0">else </span><span class="s2">{</span>
            <span class="s1">System</span><span class="s2">.</span><span class="s1">out</span><span class="s2">.</span><span class="s1">println</span><span class="s2">(</span><span class="s5">&quot;FAIL: &quot; </span><span class="s2">+ </span><span class="s1">label </span><span class="s2">+ </span><span class="s5">&quot;: Expected &quot; </span><span class="s2">+ </span><span class="s1">expected </span><span class="s2">+ </span><span class="s5">&quot; and you gave &quot; </span><span class="s2">+ </span><span class="s1">actual</span><span class="s2">);</span>
        <span class="s2">}</span>
    <span class="s2">}</span>

    <span class="s3">/**</span>
     <span class="s3">*  Checks the Body class to make sure calcForceExertedByXY works.</span>
     <span class="s3">*/</span>
    <span class="s0">private static void </span><span class="s1">checkCalcForceExertedByXY</span><span class="s2">() {</span>
        <span class="s1">System</span><span class="s2">.</span><span class="s1">out</span><span class="s2">.</span><span class="s1">println</span><span class="s2">(</span><span class="s5">&quot;Checking calcForceExertedByX and calcForceExertedByY...&quot;</span><span class="s2">);</span>

        <span class="s1">CelestialBody p1 </span><span class="s2">= </span><span class="s0">new </span><span class="s1">CelestialBody</span><span class="s2">(</span><span class="s6">1.0</span><span class="s2">, </span><span class="s6">1.0</span><span class="s2">, </span><span class="s6">3.0</span><span class="s2">, </span><span class="s6">4.0</span><span class="s2">, </span><span class="s6">5.0</span><span class="s2">, </span><span class="s5">&quot;jupiter.gif&quot;</span><span class="s2">);</span>
        <span class="s1">CelestialBody p2 </span><span class="s2">= </span><span class="s0">new </span><span class="s1">CelestialBody</span><span class="s2">(</span><span class="s6">2.0</span><span class="s2">, </span><span class="s6">1.0</span><span class="s2">, </span><span class="s6">3.0</span><span class="s2">, </span><span class="s6">4.0</span><span class="s2">, </span><span class="s6">4e11</span><span class="s2">, </span><span class="s5">&quot;jupiter.gif&quot;</span><span class="s2">);</span>
        <span class="s1">CelestialBody p3 </span><span class="s2">= </span><span class="s0">new </span><span class="s1">CelestialBody</span><span class="s2">(</span><span class="s6">4.0</span><span class="s2">, </span><span class="s6">5.0</span><span class="s2">, </span><span class="s6">3.0</span><span class="s2">, </span><span class="s6">4.0</span><span class="s2">, </span><span class="s6">5.0</span><span class="s2">, </span><span class="s5">&quot;jupiter.gif&quot;</span><span class="s2">);</span>

        <span class="s1">checkEquals</span><span class="s2">(</span><span class="s1">p1</span><span class="s2">.</span><span class="s1">calcForceExertedByX</span><span class="s2">(</span><span class="s1">p2</span><span class="s2">), </span><span class="s6">133.4</span><span class="s2">, </span><span class="s5">&quot;calcForceExertedByX()&quot;</span><span class="s2">, </span><span class="s6">0.01</span><span class="s2">);</span>
        <span class="s1">checkEquals</span><span class="s2">(</span><span class="s1">p2</span><span class="s2">.</span><span class="s1">calcForceExertedByX</span><span class="s2">(</span><span class="s1">p1</span><span class="s2">), -</span><span class="s6">133.4</span><span class="s2">, </span><span class="s5">&quot;calcForceExertedByX()&quot;</span><span class="s2">, </span><span class="s6">0.01</span><span class="s2">);</span>
        <span class="s1">checkEquals</span><span class="s2">(</span><span class="s1">p1</span><span class="s2">.</span><span class="s1">calcForceExertedByX</span><span class="s2">(</span><span class="s1">p3</span><span class="s2">), </span><span class="s6">4.002e-11</span><span class="s2">, </span><span class="s5">&quot;calcForceExertedByX()&quot;</span><span class="s2">, </span><span class="s6">0.01</span><span class="s2">);</span>
        <span class="s1">checkEquals</span><span class="s2">(</span><span class="s1">p1</span><span class="s2">.</span><span class="s1">calcForceExertedByY</span><span class="s2">(</span><span class="s1">p2</span><span class="s2">), </span><span class="s6">0.0</span><span class="s2">, </span><span class="s5">&quot;calcForceExertedByY()&quot;</span><span class="s2">, </span><span class="s6">0.01</span><span class="s2">);</span>
        <span class="s1">checkEquals</span><span class="s2">(</span><span class="s1">p1</span><span class="s2">.</span><span class="s1">calcForceExertedByY</span><span class="s2">(</span><span class="s1">p3</span><span class="s2">), </span><span class="s6">5.336e-11</span><span class="s2">, </span><span class="s5">&quot;calcForceExertedByY()&quot;</span><span class="s2">, </span><span class="s6">0.01</span><span class="s2">);</span>

        <span class="s7">//Added Spring 2022</span>
        
        <span class="s7">/* 
         
        System.out.println(&quot;These tests check if you implemented these methods using F*dx/r and F*dy/r, not F/r*dx and F/r*dy&quot;); 
        System.out.println(&quot;If you fail these tests AND you've made the appropriate change above, it might be because of your Java runtime. Post a question on Ed.&quot;); 
        CelestialBody p4 =new CelestialBody(0.0, 0.0, 3.0, 4.0, 5*1e10, &quot;jupiter.gif&quot;); 
        CelestialBody p5 =new CelestialBody(3000.0, 4000.0, 3.0, 4.0, 5*1e10 * Double.MIN_VALUE, &quot;jupiter.gif&quot;); 
 
        //System.out.println(Double.MIN_VALUE);             4.9E-324 
        //System.out.println(p4.calcForceExertedBy(p5));    2.9644E-320 
 
        //Roundoff error causes next test to fail: Got 1.482E-320 and 1.9763E-320 respectively for F/r * dx and F/r * dy (which we don't want) 
        checkEquals(p4.calcForceExertedByX(p5), 1.7786E-320, &quot;calcForceExertedByX()&quot;, 0.01); 
        checkEquals(p4.calcForceExertedByY(p5), 2.3715E-320, &quot;calcForceExertedByY()&quot;, 0.01);  
        */</span>
    <span class="s2">}</span>
<span class="s2">}</span>
</pre>
</body>
</html>