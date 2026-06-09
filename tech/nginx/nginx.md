Nginx is a powerful web server. uses a non threaded event driven architecture.
It can also do load balancing, caching, reverse proxying, API gateway, handle SSL certifications etc.

Install and setup:-
1. Install docker
2. docker run -it -p 8083:80 ubuntu
3. apt update && apt install nginx -y

if you go to localhost:8083 you will see nginx default page and in response headers you will see server: nginx/1.28.3

4. ls /etc/nginx
5. cd etc
6. cd nginx
7. ls
you will see nginx.conf files
8. cat nginx.conf
9. mv nginx.conf nginx-backup.conf
10. touch nginx.conf
11. We need to refresh ngnix after every change which is done by :- nginx -s reload
12.  Nginx is a web server which is listening on a particular web server. Inside http we can have multiple web servers running on different ports. 
13. if you run using nginx.txt. You will see hello from nginx conf file output and status code 200 OK
14. A single process can listen on multiple ports because a port is not “where the process runs.” A port is just a network entry point that the process opens.
Think of it like one shop with multiple doors:

Door 80    -> NGINX
Door 8080  -> NGINX
Door 443   -> NGINX

Same shop, multiple doors.

Technically, NGINX asks the operating system:

Please let me accept traffic on port 80
Please let me accept traffic on port 8080
Please let me accept traffic on port 443

The OS gives NGINX separate listening sockets for each port.

Example:

server {
listen 80;
server_name myapp.com;

    location / {
        proxy_pass http://localhost:3000;
    }
}

server {
listen 8080;
server_name myapp.com;

    location / {
        proxy_pass http://localhost:4000;
    }
}

NGINX opens two listeners:

0.0.0.0:80    -> NGINX
0.0.0.0:8080  -> NGINX

When a request comes to port 80, the OS gives it to NGINX’s port 80 socket.

When a request comes to port 8080, the OS gives it to NGINX’s port 8080 socket.

Then NGINX checks the config and decides what to do.

So this:

listen 80;

does not mean “NGINX process runs on port 80.”

It means:

NGINX opens a network socket on port 80 and waits for requests there.

A single process can open many sockets, just like a program can open many files at the same time.

Important rule: usually, two different processes cannot both listen on the exact same IP and port, like:

0.0.0.0:80

But one process can listen on many different ports:

0.0.0.0:80
0.0.0.0:443
0.0.0.0:8080

15. User enters http://myapp.com
    ↓
    Browser asks DNS: what IP is myapp.com?
    ↓
    DNS returns: 203.0.113.10
    ↓
    Browser connects to 203.0.113.10 on port 80
    ↓
    NGINX receives request on listen 80


16. Nginx is a web server so its duty to serve static file like html, css, javascript and image files. (https://docs.nginx.com/nginx/admin-guide/web-server/serving-static-content/)