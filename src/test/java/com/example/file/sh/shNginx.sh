#!/bin/bash
mkdir -p /home/app/xxx_nginx/conf.d && \
sudo tee /etc/docker/daemon.json <<-'EOF'
{
  "registry-mirrors": ["https://1197heba.mirror.aliyuncs.com"]
}
EOF