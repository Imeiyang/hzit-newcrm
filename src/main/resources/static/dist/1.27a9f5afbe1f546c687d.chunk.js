webpackJsonp([1],{55:function(e,t,r){r(69);var s=r(17)(r(67),r(75),"data-v-00768f00",null);s.options.__file="J:\\VUE资料\\iview学习\\demo\\src\\views\\register\\index.vue",s.esModule&&Object.keys(s.esModule).some(function(e){return"default"!==e&&"__esModule"!==e})&&console.error("named exports are not supported in *.vue files."),s.options.functional&&console.error("[vue-loader] index.vue: functional components are not supported with templates, they should use render functions."),e.exports=s.exports},67:function(e,t,r){"use strict";Object.defineProperty(t,"__esModule",{value:!0}),t.default={data:function(){return{formCustom:{realName:"",sex:"",tel:"",userId:"",companyId:36},ruleCustom:{realName:[{validator:function(e,t,r){""===t?r(new Error("请输入用户!")):r()},required:!0,trigger:"blur"}],sex:[{validator:function(e,t,r){""===t?r(new Error("请选择性别!")):r()},required:!0,trigger:"blur"}],tel:[{validator:function(e,t,r){var s=/^1[3|4|5|8][0-9]\d{4,8}$/;""===t?r(new Error("请输入手机号码!")):s.test(t)?r():r(new Error("手机号码格式不正确!"))},required:!0,trigger:"blur"}],userId:[{validator:function(e,t,r){""===t?r(new Error("请选择咨询师")):r()},required:!0,trigger:"change"}]},users:[],customers:[],customerIndex:0}},methods:{handleSubmit:function(e){var t=this;this.$refs[e].validate(function(r){if(r){t.$Message.success("提交成功!");var s=t;t.$.post("http://localhost:8090/foreground/saveUser",t.formCustom).then(function(t){600===t.code?(s.success(t.msg),s.handleReset(e),s.getAjaxData()):s.error(t.msg)}).catch(function(e){this.error("服务器出错啦!")})}else t.$Message.error("表单验证失败!")})},handleReset:function(e){this.$refs[e].resetFields()},success:function(e){this.$Notice.success({title:"处理结果",desc:e})},error:function(e){this.$Notice.error({title:"处理结果",desc:e})},edit:function(e){this.customerIndex=e},showTime:function(e){var t=new Date;t.setTime(e);var r=t,s=new Date,o=Math.floor(Math.abs(s.getTime()-r.getTime())/1e3/60/60),a=Math.floor(Math.abs(s.getTime()-r.getTime())/1e3/60-60*o),n=Math.floor(Math.abs(s.getTime()-r.getTime())/1e3-(60*o*60+60*a));return o<10&&(o="0"+o),a<10&&(a="0"+a),n<10&&(n="0"+n),o+"小时"+a+"分钟"+n+"秒"},changeTime:function(e){var t=this,r=t.customers[e].createTime,s=parseInt(r.substr(0,r.indexOf("小时"))),o=parseInt(r.substr(r.indexOf("小时")+2,r.indexOf("分钟")-4)),a=parseInt(r.substr(r.indexOf("分钟")+2).replace("秒",""));setInterval(function(){a++,a>=59&&(o++,a=0),o>=59&&(o=0,s++),t.customers[e].createTime=(s<10?"0"+s:s)+"小时"+(o<10?"0"+o:o)+"分钟"+(a<10?"0"+a:a)+"秒"},1e3)},getAjaxData:function(){var e=this;e.$axios.get("http://localhost:8090/forground/getCurrentData?companyId=36").then(function(t){for(var r=[],s=0;s<t.data.length;s++){var o={};o.realName=t.data[s].realName,o.userIdMsg=t.data[s].userIdMsg,o.tel=t.data[s].tel;var a=e.showTime(t.data[s].createTime);o.createTime=a,r.push(o)}for(e.customers=r,s=0;s<r.length;s++)e.changeTime(s)})}},mounted:function(){var e=this;this.$axios.get("http://localhost:8090/foreground/consultantData?companyId=36").then(function(t){e.users=t.data}),e.getAjaxData(),this.$Notice.config({top:500,duration:3})}}},69:function(e,t){},75:function(e,t,r){e.exports={render:function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{staticClass:"layout",attrs:{id:"register"}},[r("h1",{staticClass:"show"},[e._v("前台接待")]),e._v(" "),r("Row",{attrs:{type:"flex",gutter:35,justify:"center",align:"top"}},[r("Col",{attrs:{span:"8"}},[r("Form",{ref:"formCustom",attrs:{model:e.formCustom,rules:e.ruleCustom,"label-width":80}},[r("Form-item",{attrs:{label:"用户名",prop:"realName"}},[r("Input",{attrs:{type:"text",placeholder:"请输入姓名!"},model:{value:e.formCustom.realName,callback:function(t){e.formCustom.realName=t},expression:"formCustom.realName"}})],1),e._v(" "),r("Form-item",{attrs:{label:"性别",prop:"sex"}},[r("Radio-group",{model:{value:e.formCustom.sex,callback:function(t){e.formCustom.sex=t},expression:"formCustom.sex"}},[r("Radio",{attrs:{label:"1"}},[e._v("男")]),e._v(" "),r("Radio",{attrs:{label:"2"}},[e._v("女")])],1)],1),e._v(" "),r("Form-item",{attrs:{label:"电话号码",prop:"tel"}},[r("Input",{attrs:{type:"text",value:"13364167708",placeholder:"请输入电话号码!"},model:{value:e.formCustom.tel,callback:function(t){e.formCustom.tel=t},expression:"formCustom.tel"}})],1),e._v(" "),r("Form-item",{attrs:{label:"面试官",prop:"userId"}},[r("Select",{attrs:{placeholder:"请选择面试官!"},model:{value:e.formCustom.userId,callback:function(t){e.formCustom.userId=t},expression:"formCustom.userId"}},e._l(e.users,function(t){return r("Option",{attrs:{value:t.userId}},[e._v(e._s(t.name))])}))],1),e._v(" "),r("Form-item",[r("Button",{attrs:{size:"small",type:"primary"},on:{click:function(t){e.handleSubmit("formCustom")}}},[e._v("保存")]),e._v(" "),r("Button",{staticStyle:{"margin-left":"8px"},attrs:{size:"small",type:"ghost"},on:{click:function(t){e.handleReset("formCustom")}}},[e._v("重置")])],1)],1)],1),e._v(" "),r("Col",{attrs:{span:"14"}},[r("Timeline",{staticClass:"waitTime"},e._l(e.customers,function(t,s){return r("Timeline-item",{attrs:{color:"green"}},[r("Icon",{attrs:{type:"ios-timer"},slot:"dot"}),e._v(" "),r("Alert",{staticClass:"wait-list-content"},[r("span",{staticClass:"wait-list"},[r("Icon",{attrs:{type:"android-person"}}),e._v("  "+e._s(t.realName)+"   \n            "),r("Icon",{attrs:{type:"ios-telephone"}}),e._v(" "+e._s(t.tel)+"  \n            "),r("span",[r("Icon",{attrs:{type:"clock"}}),e._v("  "+e._s(t.createTime)+"  \n            ")],1),e._v(" "),r("Icon",{attrs:{type:"pin"}}),e._v("  "+e._s(t.realName)+"  \n            "),r("Icon",{attrs:{type:"ios-people"}}),e._v("  "+e._s(t.userIdMsg)+"\n        \n          ")],1),e._v(" "),r("router-link",{attrs:{to:{path:"/zixun/register/editUser",query:{customerName:t.realName}}}},[r("Button",{staticClass:"wait-list-btn",attrs:{value:"",type:"primary",size:"small",icon:"edit"},on:{click:function(t){e.edit(s)}}},[e._v("修改")])],1)],1)],1)}))],1)],1),e._v(" "),r("router-view")],1)},staticRenderFns:[]},e.exports.render._withStripped=!0}});