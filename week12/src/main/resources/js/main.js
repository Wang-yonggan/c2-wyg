//固定语法，new Vue({}) 在大括号里面写代码
new Vue({
    //5.指明vue作用域  <div id="app"></div>
    el: '#app',
    //6.数据区
    data() {
        return {
            tempNumber: '',
            imgFlag: false,
            imgUrl:'https://cube.elemecdn.com/6/94/4d3ea53c084bad6931a56d5158a48jpeg.jpeg',
            imgTitle:'加载失败',
            user: {
                name: '',
                psw: ''
            },
            currentPage: 1,
            tableData: []



        }
    },
    //7.钩子函数之一，create表示vue启动时就会运行。一启动就会运行。
    created() {

    },
    //8.所有的方法都会在这里
    methods: {
        //1.删除
        del() {
            var flag = confirm("确认删除?")
            $("#id1").remove()
            $("#id2").remove()
        }
        ,
        cal() {
            var that=this
            var num=that.tempNumber
            var old=num
            if(isNaN(num))
                alert("不是数字")
            else {
                that.tempNumber = 0
                while (num > 0) {
                    that.tempNumber += num % 10
                    num -= num % 10
                    num /= 10
                }
                alert(old+"位数和为"+that.tempNumber)
            }
        },
        img() {
            that=this
            that.imgFlag=!that.imgFlag
        },
        login() {
            if(this.user.name=='admin'&&this.user.psw=='admin')
                window.location.href = "http://www.baidu.com";
            else alert("密码错误")
        },
        handleCurrentChange() {

        },
        getData() {
            that=this
            axios
              .get('http://jsonplaceholder.typicode.com/users')
              .then(response => {
                  console.log(response)
                  that.tableData=response.data
              })
              .catch(function (error) { // 请求失败处理
                console.log(error);
              });
        }

    }
})