$(document).ready(function () {

    initWeekTeam();
    initCheck2();
    initZhanbi();
});


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

    $.ajax({
        type: "post",
        async: true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
        url: "/admin/getWeekData",    //请求发送到TestServlet处
        /*data : {},
        dataType : "json",*/        //返回数据形式为json
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
                    color: '#F28957'
                }
            },
            data: []
        }]
    });

    myChart.showLoading();    //数据加载完之前先显示一段简单的loading动画

    var names = [];    //类别数组（实际用来盛放X轴坐标值）
    var nums = [];    //销量数组（实际用来盛放Y坐标值）

    $.ajax({
        type: "post",
        async: true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
        url: "/admin/getWeekData2",    //请求发送到TestServlet处
        /*data : {},
        dataType : "json",*/        //返回数据形式为json
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
            left: 'center',
            top: 20,
            textStyle: {
                color: '#ccc'
            }
        },

        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
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
                label: {
                    normal: {
                        textStyle: {
                            color: 'rgba(255, 255, 255, 0.3)'
                        }
                    }
                },
                labelLine: {
                    normal: {
                        lineStyle: {
                            color: 'rgba(255, 255, 255, 0.3)'
                        },
                        smooth: 0.2,
                        length: 10,
                        length2: 20
                    }
                },
                itemStyle: {
                    normal: {
                        color: '#c23531',
                        shadowBlur: 200,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
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

    myChart.setOption(option);

    $.ajax({
        type: "post",
        async: true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
        url: "/admin/getWeekData3",    //请求发送到TestServlet处
        /*data : {},
        dataType : "json",*/        //返回数据形式为json
        success: function (result) {
            //请求成功时执行该函数内容，result即为服务器返回的json对象

            myChart.hideLoading();    //隐藏加载动画
            myChart.setOption({       //加载数据图表
                series: [{
                    // 根据名字对应到相应的系列
                    name: '扣分占比',
                    data:[result].sort(function (a, b) { return a.value - b.value; }),
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