const CACHE_NAME = 'ethiolegacy-shell-v1';
const SHELL = ['./', './index.html', './manifest.webmanifest', './icons/icon-192.png', './icons/icon-512.png'];
self.addEventListener('install', event => {
  event.waitUntil(caches.open(CACHE_NAME).then(cache => cache.addAll(SHELL)).then(() => self.skipWaiting()));
});
self.addEventListener('activate', event => {
  event.waitUntil(caches.keys().then(keys => Promise.all(keys.filter(k => k !== CACHE_NAME).map(k => caches.delete(k)))).then(() => self.clients.claim()));
});
self.addEventListener('fetch', event => {
  const req = event.request;
  if (req.method !== 'GET' || new URL(req.url).origin !== self.location.origin) return;
  // Network-first for HTML to avoid keeping an old app version; cache fallback for offline shell.
  if (req.mode === 'navigate' || req.url.endsWith('/index.html')) {
    event.respondWith(fetch(req).then(res => { const copy=res.clone(); caches.open(CACHE_NAME).then(c=>c.put(req,copy)); return res; }).catch(() => caches.match(req).then(r => r || caches.match('./index.html'))));
  } else {
    event.respondWith(caches.match(req).then(cached => cached || fetch(req).then(res => { if (res.ok) { const copy=res.clone(); caches.open(CACHE_NAME).then(c=>c.put(req,copy)); } return res; })));
  }
});
