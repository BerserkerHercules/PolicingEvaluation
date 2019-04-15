$(document).ready(function () {

    initWeekTeam();
    initCheck2();
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