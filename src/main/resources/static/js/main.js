// --- Dropdown de perfil ---
(function () {
  const btn = document.getElementById('profileBtn');
  const dropdown = document.getElementById('profileDropdown');
  if (!btn || !dropdown) return;

  btn.addEventListener('click', (e) => {
    e.stopPropagation();
    const open = dropdown.classList.toggle('profile-dropdown--open');
    btn.setAttribute('aria-expanded', open);
  });

  document.addEventListener('click', () => {
    dropdown.classList.remove('profile-dropdown--open');
    btn.setAttribute('aria-expanded', 'false');
  });
})();

// --- Filtro de status na listagem ---
document.addEventListener('DOMContentLoaded', () => {
  const filterBtns = document.querySelectorAll('.filter-btn');
  const rows = document.querySelectorAll('.posts-table tbody tr[data-status]');

  filterBtns.forEach(btn => {
    btn.addEventListener('click', () => {
      filterBtns.forEach(b => b.classList.remove('active'));
      btn.classList.add('active');

      const filter = btn.dataset.filter;

      rows.forEach(row => {
        if (filter === 'all' || row.dataset.status === filter) {
          row.style.display = '';
        } else {
          row.style.display = 'none';
        }
      });
    });
  });

  // --- Animação stagger nas linhas da tabela ---
  rows.forEach((row, i) => {
    row.style.animationDelay = `${i * 0.05}s`;
    row.style.animation = 'fadeUp .4s ease both';
  });

  // --- Animação de entrada nos feature-cards via IntersectionObserver ---
  const observer = new IntersectionObserver((entries) => {
    entries.forEach(entry => {
      if (entry.isIntersecting) {
        entry.target.style.opacity = '1';
        entry.target.style.transform = 'translateY(0)';
      }
    });
  }, { threshold: 0.1 });

  document.querySelectorAll('.feature-card').forEach(card => {
    card.style.opacity = '0';
    card.style.transform = 'translateY(24px)';
    card.style.transition = `opacity .5s ease ${card.style.getPropertyValue('--delay') || '0s'}, transform .5s ease ${card.style.getPropertyValue('--delay') || '0s'}`;
    observer.observe(card);
  });

  document.querySelectorAll('.td--data').forEach(td => {
    const partes = td.textContent.trim().split('-');
    if (partes.length === 3) {
      td.textContent = `${partes[2]}/${partes[1]}/${partes[0]}`;
    }
  });

  document.querySelectorAll('.tr--clickable').forEach(row => {
    row.addEventListener('click', () => {
      window.location.href = row.dataset.href;
    });
  });
});

(function () {
  const modal = document.getElementById('confirmModal');
  if (!modal) return;

  const itemLabel = document.getElementById('confirmModalItem');
  const confirmBtn = document.getElementById('confirmModalConfirm');
  let pendingForm = null;

  function openModal(form) {
    pendingForm = form;
    itemLabel.textContent = `${form.dataset.titulo}`;
    modal.classList.add('modal--open');
    modal.setAttribute('aria-hidden', 'false');
    confirmBtn.focus();
    document.body.style.overflow = 'hidden';
  }

  function closeModal() {
    pendingForm = null;
    modal.classList.remove('modal--open');
    modal.setAttribute('aria-hidden', 'true');
    document.body.style.overflow = '';
  }

  document.querySelectorAll('.form--delete').forEach(form => {
    form.addEventListener('submit', (e) => {
      e.preventDefault();
      openModal(form);
    });
  });

  confirmBtn.addEventListener('click', () => {
    if (pendingForm) {
      pendingForm.submit();
    }
  });

  modal.querySelectorAll('[data-modal-close]').forEach(el => {
    el.addEventListener('click', closeModal);
  });

  document.addEventListener('keydown', (e) => {
    if (e.key === 'Escape' && modal.classList.contains('modal--open')) {
      closeModal();
    }
  });
})();