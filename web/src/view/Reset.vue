<template>
  <div class="reset-container">
    <div class="reset-card">
      <div class="reset-header">
        <h1 class="reset-title">重置密码</h1>
      </div>

      <a-form
          :model="resetMember"
          name="reset"
          @finish="resetPassword"
          @finishFailed="resetFailed"
          layout="vertical"
          class="reset-form"
      >
        <a-form-item
            name="mobile"
            :rules="[
              { required: true, message: '请输入手机号!' },
              { pattern: /^1[3-9]\d{9}$/, message: '请输入正确的手机号!' }
            ]"
        >
          <a-input
              v-model:value="resetMember.mobile"
              placeholder="手机号"
              size="large"
              class="reset-input"
          >
            <template #prefix>
              <MobileOutlined class="input-icon"/>
            </template>
          </a-input>
        </a-form-item>

        <a-form-item
            name="smsCode"
            :rules="[{ required: true, message: '请输入短信验证码!' }]"
        >
          <a-input
              v-model:value="resetMember.smsCode"
              placeholder="短信验证码"
              size="large"
              class="reset-input sms-input"
          >
            <template #prefix>
              <SafetyOutlined class="input-icon"/>
            </template>
            <template #suffix>
              <a-button
                  type="primary"
                  size="small"
                  class="sms-button"
                  :disabled="smsCountdown > 0"
                  @click="sendSmsCode"
              >
                {{ smsCountdown > 0 ? `${smsCountdown}s` : '获取验证码' }}
              </a-button>
            </template>
          </a-input>
        </a-form-item>

        <a-form-item
            name="password"
            :rules="[
              { required: true, message: '请输入新密码!' },
              { min: 6, message: '密码至少6位!' }
            ]"
        >
          <a-input-password
              v-model:value="resetMember.password"
              placeholder="密码"
              size="large"
              class="reset-input"
          >
            <template #prefix>
              <LockOutlined class="input-icon"/>
            </template>
          </a-input-password>
        </a-form-item>

        <a-form-item
            name="confirmPassword"
            :rules="[
              { required: true, message: '请确认新密码!' },
              { validator: validateConfirmPassword }
            ]"
        >
          <a-input-password
              v-model:value="resetMember.confirmPassword"
              placeholder="确认密码"
              size="large"
              class="reset-input"
          >
            <template #prefix>
              <CheckCircleOutlined class="input-icon"/>
            </template>
          </a-input-password>
        </a-form-item>

        <a-form-item>
          <a-button
              type="primary"
              html-type="submit"
              size="large"
              class="reset-button"
              block
          >
            重置密码
          </a-button>
        </a-form-item>
      </a-form>

      <div class="reset-footer">
        <router-link to="/login" class="footer-link">
          <LeftOutlined class="back-icon"/>
          返回登录
        </router-link>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue';
import { useRouter } from 'vue-router';
import { 
  MobileOutlined, 
  SafetyOutlined, 
  LockOutlined, 
  CheckCircleOutlined,
  LeftOutlined 
} from '@ant-design/icons-vue';
import { message } from 'ant-design-vue';

const router = useRouter();

const resetMember = ref({
  mobile: '',
  smsCode: '',
  password: '',
  confirmPassword: '',
});

const smsCountdown = ref(0);

// 发送短信验证码
const sendSmsCode = async () => {
  if (!resetMember.value.mobile) {
    message.warning('请先输入手机号');
    return;
  }
  
  if (!/^1[3-9]\d{9}$/.test(resetMember.value.mobile)) {
    message.warning('请输入正确的手机号');
    return;
  }

  try {
    // 这里可以添加发送短信验证码的API调用
    console.log('发送重置密码验证码到:', resetMember.value.mobile);
    message.success('验证码已发送');
    
    // 开始倒计时
    smsCountdown.value = 60;
    const timer = setInterval(() => {
      smsCountdown.value--;
      if (smsCountdown.value <= 0) {
        clearInterval(timer);
      }
    }, 1000);
  } catch (error) {
    console.error('发送短信验证码失败:', error);
    message.error('发送验证码失败，请重试');
  }
};

// 确认密码验证
const validateConfirmPassword = async (rule, value) => {
  if (value && value !== resetMember.value.password) {
    return Promise.reject('两次输入的密码不一致');
  }
  return Promise.resolve();
};

// 重置密码
const resetPassword = async (values) => {
  try {
    console.log('重置密码信息:', values);
    // 这里可以添加重置密码API调用
    message.success('密码重置成功');
    // 重置成功后跳转到登录页
    router.push('/login');
  } catch (error) {
    console.error('重置密码失败:', error);
    message.error('重置密码失败，请重试');
  }
};

const resetFailed = (errorInfo) => {
  console.log('重置密码失败:', errorInfo);
};
</script>

<style scoped>
.reset-container {
  min-height: 100vh;
  background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
  display: flex;
  align-items: center;
  justify-content: center;
  padding: 20px;
}

.reset-card {
  background: white;
  border-radius: 20px;
  padding: 40px;
  width: 100%;
  max-width: 400px;
  box-shadow: 0 20px 40px rgba(0, 0, 0, 0.1);
  position: relative;
}

.reset-header {
  text-align: center;
  margin-bottom: 30px;
}

.reset-title {
  font-size: 24px;
  font-weight: 600;
  color: #333;
  margin: 0;
  letter-spacing: 1px;
}

.reset-form {
  margin-bottom: 20px;
}

.reset-input {
  border-radius: 12px;
  border: 1px solid #e8e8e8;
  transition: all 0.3s ease;
}

.reset-input:hover,
.reset-input:focus {
  border-color: #4096ff;
  box-shadow: 0 0 0 2px rgba(64, 150, 255, 0.1);
}

.input-icon {
  color: #999;
}

.sms-input .ant-input {
  padding-right: 120px;
}

.sms-button {
  height: 32px;
  border-radius: 8px;
  font-size: 12px;
  padding: 0 12px;
  background: linear-gradient(135deg, #4096ff 0%, #1677ff 100%);
  border: none;
  transition: all 0.3s ease;
}

.sms-button:hover:not(:disabled) {
  background: linear-gradient(135deg, #1677ff 0%, #0958d9 100%);
  transform: translateY(-1px);
  box-shadow: 0 4px 12px rgba(64, 150, 255, 0.3);
}

.sms-button:disabled {
  background: #f5f5f5;
  color: #999;
  cursor: not-allowed;
}

.reset-button {
  height: 48px;
  border-radius: 12px;
  background: linear-gradient(135deg, #4096ff 0%, #1677ff 100%);
  border: none;
  font-size: 16px;
  font-weight: 500;
  letter-spacing: 1px;
  transition: all 0.3s ease;
}

.reset-button:hover {
  background: linear-gradient(135deg, #1677ff 0%, #0958d9 100%);
  transform: translateY(-1px);
  box-shadow: 0 8px 20px rgba(64, 150, 255, 0.3);
}

.reset-footer {
  display: flex;
  justify-content: center;
  align-items: center;
  margin-top: 20px;
}

.footer-link {
  color: #666;
  text-decoration: none;
  font-size: 14px;
  transition: color 0.3s ease;
  display: flex;
  align-items: center;
  gap: 6px;
}

.footer-link:hover {
  color: #4096ff;
}

.back-icon {
  font-size: 12px;
}

/* 响应式设计 */
@media (max-width: 480px) {
  .reset-card {
    padding: 30px 20px;
    margin: 10px;
  }

  .reset-title {
    font-size: 20px;
  }

  .sms-input .ant-input {
    padding-right: 100px;
  }

  .sms-button {
    font-size: 11px;
    padding: 0 8px;
  }
}
</style>
