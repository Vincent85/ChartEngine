# ChartEngine

##Android 图表库。当前支持一下几种类型图表：
 * 点状图表
 * 折线图表
 * 柱状图表
 * 饼图
 * 支持通过拓展基类增加其他图表类型···
 
 ##当前支持以下特性：
 *通过设置Renderer类属性自定义图表样式，包括字体大小、颜色，线条颜色、大小等
 *通过设置Renderer打开/关闭显示动画
 
 基本示例截图如下所示：<br />
 *点状图表 <br />
 ![](https://github.com/Vincent85/ChartEngine/raw/master/screenshot/pointchart-1.gif) <br />
 *折线图表 <br />
 ![](https://github.com/Vincent85/ChartEngine/raw/master/screenshot/polylinechart-1.gif) <br />
 *柱状图表 <br />
 ![](https://github.com/Vincent85/ChartEngine/raw/master/screenshot/barchart-1.gif) <br />
 *饼图 <br />
 ![](https://github.com/Vincent85/ChartEngine/raw/master/screenshot/PieChart-1.png)  <br />
 
 使用方法：<br />
 * 获取点状图表 <br />  
```java
ChartView chartView = ChartFactory.getPointChartView(this,generateSeries(),generatePointRenderer());
```
```java
private LineChartSeries generateSeries() {
    String[] xLabels = new String[]{"1","2","3","4","5","6","7","8","9","10","11","12"};
    String[] yLabels = new String[]{"0","10","20","30","40","50","60","70","80","90","100"};
    int[] xValues = new int[]{1,2,3,4,5,6,7,8,9,10,11,12};
    int[] yValues = new int[]{12,34,56,34,23,11,6,10,25,0,77,100};
    LineChartSeries series = new LineChartSeries(xValues, yValues, xLabels, yLabels,0,12,0,100);
    return series;
}    
```
```java
private PointChartRenderer generatePointRenderer() {
    PointChartRenderer render = new PointChartRenderer(getApplicationContext());
    render.setApplyBgColor(true);
    render.setmBgColor(Color.BLACK);
    render.setmTitle("我是标题");

    render.setmXTitle("我是x轴");
    render.setmYTitle("我是y轴");

    render.setmLegendHeight(SystemUtil.dip2px(this, 90));

    return render;
}
```
* 获取其他类型图表View方法类似，可参考ChartActivity中相关用法。
