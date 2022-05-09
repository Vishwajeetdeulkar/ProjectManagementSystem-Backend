#!/bin/sh
echo "Ansible Entrypoint"

echo "[azure]" >> /hosts
echo "20.83.212.97" >> /hosts

echo "[all:vars]" >> /hosts
echo "ansible_python_interpreter=/usr/bin/python3" >> /hosts
echo "ansible_connection=ssh" >> /hosts
echo "ansible_user= $SSH_USER" >> /hosts
echo "ansible_ssh_user= $SSH_USER" >> /hosts
echo "ansible_python_interpreter=/usr/bin/python3.6" >> /hosts

echo "ansible_ssh_pass=$SSH_PASSWORD" >> /hosts
echo "ansible_become_pass=$SSH_PASSWORD" >> /hosts

echo "Entering the ansible using ansible-playbook"

ansible-playbook ansible/playbook.yml --user $SSH_USER
