// 等待DOM完全加载后执行
document.addEventListener('DOMContentLoaded', () => {
    // 获取DOM元素
    const emailInput = document.getElementById('email');
    const submitBtn = document.getElementById('submitBtn');
    const resultDiv = document.getElementById('result');

    // 校验DOM元素是否存在
    if (!emailInput || !submitBtn || !resultDiv) {
        console.error('请检查DOM元素id是否正确！');
        return;
    }

    // 按钮点击事件（核心：替换submit事件为click）
    submitBtn.addEventListener('click', async () => {
        // 1. 验证邮箱格式
        const email = emailInput.value.trim();
        const emailReg = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;
        if (!emailReg.test(email)) {
            showResult('请输入有效的邮箱地址！', 'error');
            return;
        }

        // 2. 请求前状态处理
        submitBtn.disabled = true;
        submitBtn.innerHTML = '<span class="loading"></span>正在获取...';
        resultDiv.style.display = 'none';

        try {
            // 3. 发送Post请求到本地接口
            const response = await fetch('/api/map_key_setup', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({ email: email })
            });

            // 4. 解析响应数据（先判断响应是否正常）
            if (!response.ok) {
                const errorData = await response.json().catch(() => ({ message: '接口返回非JSON数据' }));
                showResult(`获取失败：${errorData.message || '接口返回异常'}`, 'error');
                return;
            }

            const data = await response.json();
            showResult(`${data.msg || '请查看接口返回数据'}`, 'success');

        } catch (error) {
            // 5. 捕获网络/解析异常
            showResult(`网络错误：${error.message || '无法连接到服务器'}`, 'error');
            console.error('请求异常：', error);
        } finally {
            // 6. 恢复按钮状态（无论成功失败都执行）
            submitBtn.disabled = false;
            submitBtn.innerHTML = '获取密钥';
        }
    });

    // 显示结果提示函数
    function showResult(message, type) {
        resultDiv.textContent = message;
        resultDiv.className = `result ${type}`;
        resultDiv.style.display = 'block';
    }

    // 可选：给邮箱输入框加回车触发（提升体验）
    emailInput.addEventListener('keydown', (e) => {
        if (e.key === 'Enter') {
            submitBtn.click(); // 回车触发按钮点击
        }
    });
});