function get(id){
    var obj=document.getElementById(id)
    return obj
}
function f1(id){
    alert("aaaaa")
}
function f2(){
    document.getElementById("id2").onclick=function (){
        alert("bbb")
    }

}