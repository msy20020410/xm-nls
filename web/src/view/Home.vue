<template>
  <a-layout>
    <Header></Header>
    <a-layout-content style="padding: 0 50px">
      <a-breadcrumb style="margin: 16px 0">
        <a-breadcrumb-item>Home</a-breadcrumb-item>
        <a-breadcrumb-item>List</a-breadcrumb-item>
        <a-breadcrumb-item>App</a-breadcrumb-item>
      </a-breadcrumb>
      <a-layout style="padding: 24px 0; background: #fff">
        <Sider></Sider>
        <a-layout-content :style="{ padding: '0 24px', minHeight: '280px' }">
          Content
          <a-button type="primary" @click="send">点击发请求</a-button>
        </a-layout-content>
      </a-layout>
    </a-layout-content>
    <a-layout-footer style="text-align: center">
      Ant Design ©2018 Created by Ant UED
    </a-layout-footer>
  </a-layout>
</template>
<script setup>
import Header from "../components/Header.vue";
import Sider from "../components/Sider.vue";
import axios from "axios";
import service from "../utils/request.js";

//
function send() {
  // axios.get("http://localhost:18000/nls/pass", {
  //   params: {
  //     name: "张三"
  //   }
  // }).then(response => {
  //   alert(response.data.content);
  //   console.log(response);
  // });
  service("/pass", {params: {name: "王五"}});
}
</script>
<style scoped>

</style>