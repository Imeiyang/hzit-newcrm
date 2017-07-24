webpackJsonp([6],{45:function(e,t,o){var r=o(17)(o(52),o(67),null,null);r.options.__file="J:\\VUE资料\\iview学习\\demo\\src\\views\\grant\\user\\addUser.vue",r.esModule&&Object.keys(r.esModule).some(function(e){return"default"!==e&&"__esModule"!==e})&&console.error("named exports are not supported in *.vue files."),r.options.functional&&console.error("[vue-loader] addUser.vue: functional components are not supported with templates, they should use render functions."),e.exports=r.exports},52:function(e,t,o){"use strict";Object.defineProperty(t,"__esModule",{value:!0}),t.default={data:function(){return{employeeForm:{name:"",gender:"",tel:"",email:"",wechatNo:"",companyId:"",deptId:"",isConsultant:""},employeeRule:{name:[{validator:function(e,t,o){""===t?o(new Error("请输入用户!")):o()},required:!0,trigger:"blur"}],gender:[{validator:function(e,t,o){""===t?o(new Error("请选中性别!")):o()},required:!0}],email:[{validator:function(e,t,o){""===t?o(new Error("请输入邮箱!")):o()},required:!0,trigger:"blur"}],wechatNo:[{validator:function(e,t,o){""===t?o(new Error("请输入微信号!")):o()},required:!0,trigger:"blur"}],companyId:[{validator:function(e,t,o){""===t?o(new Error("请选择公司!")):o()},required:!0,trigger:"change"}],deptId:[{validator:function(e,t,o){""===t?o(new Error("请选择部门!")):o()},required:!0,trigger:"change"}],isConsultant:[{validator:function(e,t,o){""===t?o(new Error("请选择是否是咨询师!")):o()},required:!0,trigger:"change"}]}}},methods:{handleSubmit:function(e){var t=this;this.$refs[e].validate(function(e){e?t.$Message.success("表单验证成功!"):t.$Message.error("表单验证失败!")})},handleReset:function(e){console.log(e),this.$refs[e].resetFields()}}}},67:function(e,t,o){e.exports={render:function(){var e=this,t=e.$createElement,o=e._self._c||t;return o("Form",{ref:"employeeForm",attrs:{model:e.employeeForm,rules:e.employeeRule,"label-width":100}},[o("Form-item",{attrs:{label:"用户名",prop:"name"}},[o("Input",{attrs:{placeholder:"请输入用户名!"},model:{value:e.employeeForm.name,callback:function(t){e.employeeForm.name=t},expression:"employeeForm.name"}})],1),e._v(" "),o("Form-item",{attrs:{label:"性别",prop:"gender"}},[o("Radio-group",{model:{value:e.employeeForm.gender,callback:function(t){e.employeeForm.gender=t},expression:"employeeForm.gender"}},[o("Radio",{attrs:{label:"1"}},[e._v("男")]),e._v(" "),o("Radio",{attrs:{label:"2"}},[e._v("女")])],1)],1),e._v(" "),o("Form-item",{attrs:{label:"手机号码",prop:"tel"}},[o("Input",{attrs:{type:"text",placeholder:"请输入手机号码!"},model:{value:e.employeeForm.tel,callback:function(t){e.employeeForm.tel=t},expression:"employeeForm.tel"}})],1),e._v(" "),o("Form-item",{attrs:{label:"邮箱",prop:"email"}},[o("Input",{attrs:{type:"text",placeholder:"请输入邮箱!"},model:{value:e.employeeForm.email,callback:function(t){e.employeeForm.email=t},expression:"employeeForm.email"}})],1),e._v(" "),o("Form-item",{attrs:{label:"微信号",prop:"wechatNo"}},[o("Input",{attrs:{type:"text",placeholder:"请输入微信号!"},model:{value:e.employeeForm.wechatNo,callback:function(t){e.employeeForm.wechatNo=t},expression:"employeeForm.wechatNo"}})],1),e._v(" "),o("Form-item",{attrs:{label:"所属公司",prop:"companyId"}},[o("Select",{attrs:{placeholder:"请选择所属公司!"},model:{value:e.employeeForm.companyId,callback:function(t){e.employeeForm.companyId=t},expression:"employeeForm.companyId"}},[o("Option",{attrs:{value:"beijing"}},[e._v("北京市")]),e._v(" "),o("Option",{attrs:{value:"shanghai"}},[e._v("上海市")]),e._v(" "),o("Option",{attrs:{value:"shenzhen"}},[e._v("深圳市")])],1)],1),e._v(" "),o("Form-item",{attrs:{label:"所属部门",prop:"deptId"}},[o("Select",{attrs:{placeholder:"请选择所属部门!"},model:{value:e.employeeForm.deptId,callback:function(t){e.employeeForm.deptId=t},expression:"employeeForm.deptId"}},[o("Option",{attrs:{value:"beijing"}},[e._v("北京市")]),e._v(" "),o("Option",{attrs:{value:"shanghai"}},[e._v("上海市")]),e._v(" "),o("Option",{attrs:{value:"shenzhen"}},[e._v("深圳市")])],1)],1),e._v(" "),o("Form-item",{attrs:{label:"咨询师",prop:"isConsultant"}},[o("Radio-group",{model:{value:e.employeeForm.isConsultant,callback:function(t){e.employeeForm.isConsultant=t},expression:"employeeForm.isConsultant"}},[o("Radio",{attrs:{label:"1"}},[e._v("是")]),e._v(" "),o("Radio",{attrs:{label:"2"}},[e._v("否")])],1)],1),e._v(" "),o("Form-item",[o("Button",{attrs:{type:"primary"},on:{click:function(t){e.handleSubmit("employeeForm")}}},[e._v("保存")]),e._v(" "),o("Button",{staticStyle:{"margin-left":"8px"},attrs:{type:"warning"},on:{click:function(t){e.handleReset("employeeForm")}}},[e._v("重置")]),e._v(" "),o("router-link",{attrs:{to:"/user"}},[o("Button",{staticStyle:{"margin-left":"8px"},attrs:{type:"ghost"}},[e._v("返回")])],1)],1)],1)},staticRenderFns:[]},e.exports.render._withStripped=!0}});