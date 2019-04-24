$(document).ready(function () {
    initSelect();
    //initCount();
    initWeekTeam();
    initCheck2();
    initZhanbi();
    initTimeZhanbi();
});

function initSelect() {
    $.ajax({
        url : "/admin/initSelect",     //后台请求的数据
        type : "post",                  //请求方式
        async : true,                   //是否异步请求
        success : function(data) {      //如果请求成功，返回数据。
            var xqs = data.xqs;
            var weekNum = data.weekNum;
            for(var i=0;i<xqs.length;i++){
                $(".chooseXqs").append("<option value=''>"+xqs[i]+"</option>");
            }
            for(var i=0;i<weekNum.length;i++){
                $(".chooseWeek").append("<option>第"+weekNum[i]+"周</option>");
            }
        },
    });
}
$("#chooseXqs1").change(function () {
    initWeekTeam();
});
$("#chooseWeek1").change(function () {
    initWeekTeam();
});

$("#chooseXqs2").change(function () {
    initCheck2();
});
$("#chooseWeek2").change(function () {
    initCheck2();
});

$("#chooseXqs3").change(function () {
    initZhanbi();
});
$("#chooseWeek3").change(function () {
    initZhanbi();
});

$("#chooseXqs4").change(function () {
    initTimeZhanbi();
});
$("#chooseWeek4").change(function () {
    initTimeZhanbi();
});

function initCount() {
    $.ajax({
        url : "/admin/stuCount",     //后台请求的数据
        type : "post",                  //请求方式
        async : true,                   //是否异步请求
        success : function(data) {      //如果请求成功，返回数据。
            for(var i=0;i<data.length;i++){
                $("#"+i).html(data[i]);
            }
        },
    });
}

function initWeekTeam() {

    var myChart = echarts.init(document.getElementById('main'));
    // 显示标题，图例和空的坐标轴
    myChart.setOption({
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'shadow',
            }
        },
        legend: {
            data: ['周扣分情况']
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis: {
            data: [],
            axisLine: {
                show: false, // x 轴竖线   false：不显示 true：显示
                lineStyle: {
                    color: '#A5A5A5'
                }
            },
        },
        yAxis: {
            axisLine: {
                show: true,
                lineStyle: {
                    color: '#A5A5A5' // y 轴线最下面的横坐标线的颜色
                }
            },
        },
        series: [{
            name: '被扣分的区队数',
            type: 'bar',
            barWidth: 30,//柱图宽度
            itemStyle: {
                normal: {
                    color: '#5CACEE'
                }
            },
            data: []
        }]
    });

    myChart.showLoading();    //数据加载完之前先显示一段简单的loading动画

    var names = [];    //类别数组（实际用来盛放X轴坐标值）
    var nums = [];    //销量数组（实际用来盛放Y坐标值）

    alert($("#chooseXqs1 option:selected").val());
    $.ajax({
        type: "post",
        async: true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
        url: "/admin/getWeekData",    //请求发送到TestServlet处
        data : {
            "xqs":$("#chooseXqs1").val(),
            "weekNum":$("#chooseWeek1").val()
        },
        dataType : "json",        //返回数据形式为json
        success: function (result) {
            //请求成功时执行该函数内容，result即为服务器返回的json对象
            var checkList = result.checkList;
            var dataList = result.dataList;
            for (var i = 0; i < checkList.length; i++) {
                names.push(checkList[i].checkName)
            }
            for (var i = 0; i < dataList.length; i++) {
                nums.push(dataList[i].countTeam)
            }
            myChart.hideLoading();    //隐藏加载动画
            myChart.setOption({       //加载数据图表
                xAxis: {
                    data: names,
                },
                series: [{
                    // 根据名字对应到相应的系列
                    name: '被扣分的区队数',
                    data: nums
                }]
            });

        },
        error: function (errorMsg) {
            //请求失败时执行该函数
            alert("图表请求数据失败!");
            myChart.hideLoading();
        }
    });
}


function initCheck2() {
    var myChart = echarts.init(document.getElementById('main2'));
    // 显示标题，图例和空的坐标轴
    myChart.setOption({
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'shadow',
            }
        },
        legend: {
            data: ['周扣分情况']
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis: {
            data: [],
            axisLine: {
                show: false, // x 轴竖线   false：不显示 true：显示
                lineStyle: {
                    color: '#A5A5A5'
                }
            },
        },
        yAxis: [{
            axisLine: {
                show: true,
                lineStyle: {
                    color: '#A5A5A5' // y 轴线最下面的横坐标线的颜色
                }
            },
        },
        ],
        series: [{
            name: '被扣分的区队数',
            type: 'bar',
            barWidth: 30,//柱图宽度
            itemStyle: {
                normal: {
                    color: '#F28957'
                }
            },
            data: []
        }]
    });

    myChart.showLoading();    //数据加载完之前先显示一段简单的loading动画

    var names = [];    //（实际用来盛放X轴坐标值）
    var nums = [];    //（实际用来盛放Y坐标值）

    $.ajax({
        type: "post",
        async: true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
        url: "/admin/getWeekData2",    //请求发送到TestServlet处
        data : {
            "xqs":$("#chooseXqs2").val(),
            "weekNum":$("#chooseWeek2").val()
        },
        dataType : "json",        //返回数据形式为json
        success: function (result) {
            //请求成功时执行该函数内容，result即为服务器返回的json对象
            var checkList = result.checkList;
            var dataList = result.dataList;
            for (var i = 0; i < checkList.length; i++) {
                names.push(checkList[i]);
            }
            for (var i = 0; i < dataList.length; i++) {
                nums.push(dataList[i].countTeam);
            }
            myChart.hideLoading();    //隐藏加载动画
            myChart.setOption({       //加载数据图表
                xAxis: {
                    data: names,
                },
                series: [{
                    // 根据名字对应到相应的系列
                    name: '被扣分的区队数',
                    data: nums
                }]
            });

        },
        error: function (errorMsg) {
            //请求失败时执行该函数
            alert("图表请求数据失败!");
            myChart.hideLoading();
        }
    });
}

function initZhanbi() {

    var myChart = echarts.init(document.getElementById('main3'));

    myChart.showLoading();    //数据加载完之前先显示一段简单的loading动画

    option = {
        //backgroundColor: '#2c343c',

        title: {
            text: '重点项目扣分占比',
            subtext: '仅供参考',
            left: 'center',
            top: 20,
            textStyle: {
                color: '#000000'
            }
        },

        tooltip : {
            trigger: 'item',
            formatter: "{b}<br/> 扣分数：{c}<br/> 占比：{d}%"
        },

        visualMap: {
            show: false,
            min: 80,
            max: 600,
            inRange: {
                colorLightness: [0, 1]
            }
        },
        series : [
            {
                name:'扣分占比',
                type:'pie',
                radius : '55%',
                center: ['50%', '50%'],

                roseType: 'radius',

                itemStyle: {
                    normal: {

                        shadowBlur: 200,
                        shadowColor: 'rgba(0, 0, 0, 0)'
                    }
                },

                animationType: 'scale',
                animationEasing: 'elasticOut',
                animationDelay: function (idx) {
                    return Math.random() * 200;
                }
            }
        ]
    };

    $.ajax({
        type: "post",
        async: true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
        url: "/admin/getWeekData3",    //请求发送到TestServlet处
        data : {
            "xqs":$("#chooseXqs3").val(),
            "weekNum":$("#chooseWeek3").val()
        },
        dataType : "json",        //返回数据形式为json
        success: function (result) {
            //请求成功时执行该函数内容，result即为服务器返回的json对象

            myChart.hideLoading();    //隐藏加载动画
            myChart.setOption({       //加载数据图表
                series: [{
                    // 根据名字对应到相应的系列
                    name: '扣分占比',
                    data:result.sort(function (a, b) { return a.value - b.value; }),
                }]
            });

        },
        error: function (errorMsg) {
            //请求失败时执行该函数
            alert("图表请求数据失败!");
            myChart.hideLoading();
        }
    });
    myChart.setOption(option);
}

function initTimeZhanbi() {

    var myChart = echarts.init(document.getElementById('main4'));

    myChart.showLoading();    //数据加载完之前先显示一段简单的loading动画

    option = {
        title : {
            text: '扣分日期占比',
            subtext: '仅供参考',
            x:'center'
        },
        tooltip : {
            trigger: 'item',
            formatter: "{b}<br/> 扣分数：{c}<br/> 占比：{d}%"
        },
        legend: {
            orient: 'vertical',
            left: 'left',
            data:[],
        },
        series : [
            {
                name: '扣分日期占比',
                type: 'pie',
                radius : '55%',
                center: ['50%', '60%'],
                data:[],
                itemStyle: {
                    emphasis: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                }
            }
        ]
    };
    myChart.setOption(option);
    $.ajax({
        type: "post",
        async: true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
        url: "/admin/getWeekData4",    //请求发送到TestServlet处
        data : {
            "xqs":$("#chooseXqs4").val(),
            "weekNum":$("#chooseWeek4").val()
        },
        dataType : "json",        //返回数据形式为json
        success: function (result) {
            myChart.hideLoading();    //隐藏加载动画
            myChart.setOption({       //加载数据图表
                //legend:{data:data,},
                series: [{
                    // 根据名字对应到相应的系列
                    name: '扣分日期占比',
                    data:result.sort(function (a, b) { return a.value - b.value; }),
                }]
            });

        },
        error: function (errorMsg) {
            //请求失败时执行该函数
            alert("图表请求数据失败!");
            myChart.hideLoading();
        }
    });



}