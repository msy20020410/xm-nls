import {createApp} from 'vue'
import './style.css'
import App from './App.vue'
import Antd from 'ant-design-vue';
import 'ant-design-vue/dist/reset.css';
import * as Icons from '@ant-design/icons-vue';
import router from './router'

const app = createApp(App);
// 使用ant-design-vue
app.use(Antd)
// 使用 vue-router
app.use(router);
// 全局使用图标
const icons = Icons;
for (const i in icons) {
    app.component(i, icons[i]);
}

// 启动
app.mount('#app');


