webpackJsonp([6],{54:function(e,t,r){var o=r(17)(r(66),r(87),null,null);o.options.__file="J:\\VUE资料\\iview学习\\demo\\src\\views\\register\\editUser.vue",o.esModule&&Object.keys(o.esModule).some(function(e){return"default"!==e&&"__esModule"!==e})&&console.error("named exports are not supported in *.vue files."),o.options.functional&&console.error("[vue-loader] editUser.vue: functional components are not supported with templates, they should use render functions."),e.exports=o.exports},66:function(e,t,r){"use strict";Object.defineProperty(t,"__esModule",{value:!0}),t.default={data:function(){return{formCustom:{realName:"",sex:"",tel:"",userId:"",customerId:""},ruleCustom:{realName:[{validator:function(e,t,r){""===t?r(new Error("请输入用户名!")):r()},trigger:"blur"}],sex:[{validator:function(e,t,r){""===t?r(new Error("请选择性别!")):r()},trigger:"blur"}],tel:[{validator:function(e,t,r){var o=/^1[3|4|5|8][0-9]\d{4,8}$/;""===t?r(new Error("请输入手机号码!")):o.test(t)?r():r(new Error("手机号码格式不正确!"))},trigger:"blur"}],userId:[{validator:function(e,t,r){""===t?r(new Error("请选择咨询师")):r()},required:!0,trigger:"change"}]},users:[]}},mounted:function(){function e(){t.$.get("http://localhost:8090/forground/editCustomer?realName="+r).then(function(e){t.formCustom.realName=e.realName,t.formCustom.sex=e.sex,t.formCustom.tel=e.tel,t.formCustom.userId=e.userId,t.formCustom.customerId=e.customerId})}var t=this,r=this.$route.query.customerName;this.$axios.get("http://localhost:8090/foreground/consultantData?companyId=36").then(function(r){t.users=r.data,e()}),this.$Notice.config({top:500,duration:3})},methods:{handleSubmit:function(e){var t=this;this.$refs[e].validate(function(e){var r=t;e?(t.$Message.success("表单验证成功!"),r.$.post("http://localhost:8090/forground/editCustomer",t.formCustom).then(function(e){600===e.code?(r.success(e.msg),setTimeout(function(){r.$router.push("/zixun/register")},1e3)):r.error(e.msg)}).catch(function(e){this.error("服务器出错啦!")})):r.$Message.error("表单验证失败!")})},handleReset:function(e){this.$refs[e].resetFields()},success:function(e){this.$Notice.success({title:"处理结果",desc:e})},error:function(e){this.$Notice.error({title:"处理结果",desc:e})}}}},87:function(e,t,r){e.exports={render:function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{attrs:{id:"editUser"}},[r("h2",[e._v("修改用户")]),e._v(" "),r("Form",{ref:"formCustom",attrs:{model:e.formCustom,rules:e.ruleCustom,"label-width":80}},[r("input",{directives:[{name:"model",rawName:"v-model",value:e.formCustom.customerId,expression:"formCustom.customerId"}],attrs:{type:"hidden"},domProps:{value:e.formCustom.customerId},on:{input:function(t){t.target.composing||(e.formCustom.customerId=t.target.value)}}}),e._v(" "),r("Form-item",{attrs:{label:"用户名",prop:"realName"}},[r("Input",{attrs:{type:"text"},model:{value:e.formCustom.realName,callback:function(t){e.formCustom.realName=t},expression:"formCustom.realName"}})],1),e._v(" "),r("Form-item",{attrs:{label:"性别",prop:"sex"}},[r("Radio-group",{model:{value:e.formCustom.sex,callback:function(t){e.formCustom.sex=t},expression:"formCustom.sex"}},[r("Radio",{attrs:{label:"1"}},[e._v("男")]),e._v(" "),r("Radio",{attrs:{label:"2"}},[e._v("女")])],1)],1),e._v(" "),r("Form-item",{attrs:{label:"电话号码",prop:"tel"}},[r("Input",{attrs:{type:"text",value:"13364167708",placeholder:"请输入电话号码!"},model:{value:e.formCustom.tel,callback:function(t){e.formCustom.tel=t},expression:"formCustom.tel"}})],1),e._v(" "),r("Form-item",{attrs:{label:"面试官",prop:"userId"}},[r("Select",{attrs:{placeholder:"请选择面试官!"},model:{value:e.formCustom.userId,callback:function(t){e.formCustom.userId=t},expression:"formCustom.userId"}},e._l(e.users,function(t){return r("Option",{attrs:{value:t.userId}},[e._v(e._s(t.name))])}))],1),e._v(" "),r("Form-item",[r("Button",{attrs:{type:"primary",icon:"edit"},on:{click:function(t){e.handleSubmit("formCustom")}}},[e._v("保存")]),e._v(" "),r("Button",{staticStyle:{"margin-left":"8px"},attrs:{type:"ghost",icon:"ios-refresh-empty"},on:{click:function(t){e.handleReset("formCustom")}}},[e._v("重置")]),e._v(" "),r("router-link",{attrs:{to:"/zixun/register"}},[r("Button",{attrs:{icon:"ios-undo"}},[e._v("返回")])],1)],1)],1),e._v(" "),r("router-view")],1)},staticRenderFns:[]},e.exports.render._withStripped=!0}});