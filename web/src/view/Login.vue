<template>
  <div class="login-container">
    <div class="login-card">
      <div class="login-header">
        <h1 class="login-title">XM智能语音</h1>
      </div>

      <a-form
          :model="loginMember"
          name="login"
          @finish="login"
          @finishFailed="loginFailed"
          layout="vertical"
          class="login-form"
      >
        <a-form-item
            name="mobile"
            :rules="[{ required: true, message: '请输入手机号!' }]"
        >
          <a-input
              v-model:value="loginMember.mobile"
              placeholder="手机号"
              size="large"
              class="login-input"
          >
            <template #prefix>
              <UserOutlined class="input-icon"/>
            </template>
          </a-input>
        </a-form-item>

        <a-form-item
            name="password"
            :rules="[{ required: true, message: '请输入密码!' }]"
        >
          <a-input-password
              v-model:value="loginMember.password"
              placeholder="密码"
              size="large"
              class="login-input"
          >
            <template #prefix>
              <LockOutlined class="input-icon"/>
            </template>
          </a-input-password>
        </a-form-item>

        <a-form-item>
          <a-button
              type="primary"
              html-type="submit"
              size="large"
              class="login-button"
              block
          >
            登录
          </a-button>
        </a-form-item>
      </a-form>

      <div class="login-footer">
        <router-link to="/register" class="footer-link">我要注册</router-link>
        <router-link to="/reset" class="footer-link">忘记密码</router-link>
      </div>
    </div>
  </div>
</template>

<script setup>
import {ref} from 'vue';
import {UserOutlined, LockOutlined} from '@ant-design/icons-vue';

const loginMember = ref({
  mobile: '',
  password: '',
});

const login = values => {
  console.log('登录成功:', values);
  // 这里可以添加登录逻辑
};

const loginFailed = errorInfo => {
  console.log('登录失败:', errorInfo);
};
</script>

<style scoped>
.login-container {
  min-height: 100vh;
  background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
  display: flex;
  align-items: center;
  justify-content: center;
  padding: 20px;
}

.login-card {
  background: white;
  border-radius: 20px;
  padding: 40px;
  width: 100%;
  max-width: 400px;
  box-shadow: 0 20px 40px rgba(0, 0, 0, 0.1);
  position: relative;
}

.login-header {
  text-align: center;
  margin-bottom: 30px;
}

.login-title {
  font-size: 24px;
  font-weight: 600;
  color: #333;
  margin: 0;
  letter-spacing: 1px;
}

.login-form {
  margin-bottom: 20px;
}

.login-input {
  border-radius: 12px;
  border: 1px solid #e8e8e8;
  transition: all 0.3s ease;
}

.login-input:hover,
.login-input:focus {
  border-color: #4096ff;
  box-shadow: 0 0 0 2px rgba(64, 150, 255, 0.1);
}

.input-icon {
  color: #999;
}

.login-button {
  height: 48px;
  border-radius: 12px;
  background: linear-gradient(135deg, #4096ff 0%, #1677ff 100%);
  border: none;
  font-size: 16px;
  font-weight: 500;
  letter-spacing: 1px;
  transition: all 0.3s ease;
}

.login-button:hover {
  background: linear-gradient(135deg, #1677ff 0%, #0958d9 100%);
  transform: translateY(-1px);
  box-shadow: 0 8px 20px rgba(64, 150, 255, 0.3);
}

.login-footer {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-top: 20px;
}

.footer-link {
  color: #666;
  text-decoration: none;
  font-size: 14px;
  transition: color 0.3s ease;
}

.footer-link:hover {
  color: #4096ff;
}

/* 响应式设计 */
@media (max-width: 480px) {
  .login-card {
    padding: 30px 20px;
    margin: 10px;
  }

  .login-title {
    font-size: 20px;
  }
}
</style>
