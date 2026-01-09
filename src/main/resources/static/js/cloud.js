contactForm.addEventListener('submit', (e) => {
  e.preventDefault();
  const btn = contactForm.querySelector('.submit-btn');
  btn.innerHTML = '<span>✓ 已发送</span><i class="fas fa-check"></i>';
  btn.style.background = 'linear-gradient(135deg,#2ecc71,#27ae60)';
  setTimeout(() => {
    contactForm.reset();
    btn.innerHTML = '<span>发送消息</span><i class="fas fa-paper-plane"></i>';
    btn.style = '';
  }, 2000);
});