from Tkinter import *
from PIL import ImageTk, Image
import Tkinter, Tkconstants, tkFileDialog
import os
import tkMessageBox
import sqlite3
import calendar
import datetime
import time

db = sqlite3.connect('data.db')
cursor = db.cursor()
cursor.execute("PRAGMA foreign_keys = 1")

root = Tk()
root.geometry("700x450")

LoginFrame = Frame(root)
LoginFrame.pack()

ReviewFrame = Frame(root)
PReviewFrame = Frame(root)
SReviewFrame = Frame(root)
SearchFrame = Frame(root)
SearchListFrame = Frame(root)
RegisterFrame = Frame(root)
MainInterfaceCusFrame = Frame(root)
HomestayEntryFrame = Frame(root)
SearchFrame = Frame(root)
BookingFrame = Frame(root)
PaymentFrame = Frame(root)
ReviewFrame = Frame(root)
MainInterfaceCusFrame = Frame(root)
ReportGenerationFrame = Frame(root)
MainInterfaceCusFrame = Frame(root)
MainInterfaceCusFrameFrame = Frame(root)
MainOwnerFrame = Frame(root)
MainAdminFrame = Frame(root)
UserManagementFrame = Frame(root)
AdvertisementFrame = Frame(root)


##

global currentHome
radio = IntVar()
selectInter = IntVar()

##

#______________________________________________________________________________________________________________________________________________
#///////////////////////////////////////////////////////////////// CLASSES \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
#______________________________________________________________________________________________________________________________________________


class User:			#user class involving calculations
	loginID = ""
	loginPW = ""
	userID = 0
	userName = ""
	userGender = ""
	userContact = ""
	userEmail = ""
	userAddress = ""
	userType = ""
	

	def __init__(this, logID, logPW, ID, name, gender, contact, email, address, type):
		this.loginID = logID
		this.loginPW = logPW
		this.userID = ID
		this.userName = name
		this.userGender = gender
		this.userContact = contact
		this.userEmail = email
		this.userAddress = address
		this.userType = type
		print("USER OBJECT CREATED!")
		

class Homestay:
	homeID = 0
	homeAddress = ""
	homeCity = ""
	homeState = ""
	homeOwnerID = 0
	homePrice = 0.00
	homeDesc = ""
	roomAmount = 0
	bathroomAmount = 0
	hasWindows = 0

	count = cursor.execute('SELECT COUNT(*) FROM HOMESTAY').fetchone()
	count = count[0]
	
	
	def __init__(this, address, city, state, price, desc, room, bathroom, window, id, hID = count+5001):
		this.homeID = hID 
		this.homeAddress = address
		this.homeCity = city
		this.homeState = state
		this.homeOwnerID = id
		this.homePrice = price
		this.homeDesc = desc
		this.roomAmount = room
		this.bathroomAmount = bathroom
		this.hasWindows = window

class Booking:
	bookID = 0
	userID = 0
	homeID = 0
	bookingStart = 0
	bookingEnd = 0
	price = "$400"
	
	
	count = cursor.execute('SELECT COUNT(*) FROM BOOKING').fetchone()
	count = count[0]


	def __init__(this, userID, homeID, bookingStart, bookingEnd, price, bookID=count+9001) :
		this.bookID = bookID
		this.userID = userID
		this.homeID = homeID
		this.bookingStart = bookingStart
		this.bookingEnd = bookingEnd
		this.price = price



#______________________________________________________________________________________________________________________________________________
#///////////////////////////////////////////////////////////////// FUNCTIONS \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
#______________________________________________________________________________________________________________________________________________

def onClickSearchHomestay():
	MainInterfaceCusFrame.pack_forget()

def countReview():
	global revAm
	revAm = cursor.execute('SELECT COUNT(ReviewID) FROM REVIEW').fetchone()
	revAm=revAm[0]

def onClickListHomestay():
	MainInterfaceCusFrame.pack_forget()

def onClickReview():
	MainInterfaceCusFrame.pack_forget()
	ReviewFrame.pack()
	countReview()
	
def onClickSReview():
	
	ReviewFrame.pack_forget()
	SReviewFrame.pack()
	noArr = []
	addArr = []
	ownArr = []
	revArr = []
	ratArr = []
	uIDArr = []
	 
	noArr = cursor.execute('SELECT reviewID FROM REVIEW').fetchall()
	addArr = cursor.execute('SELECT homeName FROM REVIEW').fetchall()
	ownArr = cursor.execute('SELECT ownerName FROM REVIEW').fetchall()
	revArr = cursor.execute('SELECT review FROM REVIEW').fetchall()
	ratArr = cursor.execute('SELECT rating FROM REVIEW').fetchall()
	uIDArr = cursor.execute('SELECT userID FROM REVIEW').fetchall()
	
	i=0
	j=0
	while(True):	 
		revNo=noArr[i][0]
		hName=addArr[i][0]
		oName=ownArr[i][0]
		rev=revArr[i][0]
		rat=ratArr[i][0]
		uID=uIDArr[i][0]
		
		lbl0 = Label(SReviewFrame, text="ReviewNumber: " + str(revNo))
		lbl1 = Label(SReviewFrame, text="Homestay Address: " + hName)
		lbl2 = Label(SReviewFrame, text="Owner's Name: " + oName)
		lbl3 = Label(SReviewFrame, text="Review: " + rev)
		lbl4 = Label(SReviewFrame, text="Rating: " + str(rat))
		lbl5 = Label(SReviewFrame, text="From User ID: " + str(uID))
		lblD = Label(SReviewFrame, text=" ")

		lbl0.grid(row=j, column=0, sticky=W)
		j=j+1
		lbl1.grid(row=j, column=0, sticky=W)
		j=j+1
		lbl2.grid(row=j, column=0, sticky=W)
		j=j+1
		lbl3.grid(row=j, column=0, sticky=W)
		j=j+1
		lbl4.grid(row=j, column=0, sticky=W)
		j=j+1
		lbl5.grid(row=j, column=0, sticky=W)
		j=j+1
		lblD.grid(row=j, column=0, sticky=W)
		j=j+2
	
		i=i+1
		if(i==revAm):
			break
 
	BackRButton = Button(SReviewFrame, text="Done", fg="black", command=BackRClicked)
	BackRButton.grid(row=j,column=1,columnspan=2)
	

def onClickPReview():
	global revNo
	revNo = revAm+1
	ReviewFrame.pack_forget()
	PReviewFrame.pack()

	lbl1 = Label(PReviewFrame, text="Homestay Address: ")
	lbl2 = Label(PReviewFrame, text="Owner's Name: ")
	lbl3 = Label(PReviewFrame, text="Review: ")
	lbl4 = Label(PReviewFrame, text="Rating: ")
	
	global hNameE 
	global oNameE
	global revE
	global ratE
	global uID
	rr = IntVar()

	hNameE = Entry(PReviewFrame, width=30)
	oNameE = Entry(PReviewFrame, width=30)
	revE = Entry(PReviewFrame, width=70)
	ratE = Entry(PReviewFrame, textvariable=rr, width=5)
	uID = current.userID
	
	
	lbl1.grid(row=1, column=0, sticky=E)
	lbl2.grid(row=2, column=0, sticky=E)
	lbl3.grid(row=3, column=0, sticky=E)
	lbl4.grid(row=4, column=0, sticky=E)
	

	hNameE.grid(row=1, column=1, sticky=W)
	oNameE.grid(row=2, column=1, sticky=W)
	revE.grid(row=3, column=1, sticky=W)
	ratE.grid(row=4, column=1, sticky=W)

	PostButton = Button(PReviewFrame, text="Post", fg="black", command=PostClicked)
	PostButton.grid(row=6,column=1,columnspan=2)
	CPostButton = Button(PReviewFrame, text="Cancel", fg="black", command=CPostClicked)
	CPostButton.grid(row=6,column=2,columnspan=2)

def onClickBReview():
	ReviewFrame.pack_forget()
	MainInterfaceCusFrame.pack()

def BackRClicked():
	SReviewFrame.pack_forget()
	MainInterfac+eCusFrame.pack()

def PostClicked():
	tkMessageBox.showinfo(" ","Review has been Posted!")
	time.sleep(0.5)
	PReviewFrame.pack_forget()
	MainInterfaceCusFrame.pack()
	entry = (revNo,hNameE.get(),oNameE.get(),revE.get(),int(ratE.get()),uID)
	db.commit()
	cursor.execute('INSERT INTO REVIEW VALUES (?,?,?,?,?,?)',entry)
	db.commit()
	countReview()

def CPostClicked():
	PReviewFrame.pack_forget()
	ReviewFrame.pack()


def LoginRegisterClicked():
	LoginFrame.pack_forget()
	RegisterFrame.pack()

def RegisterClicked():
	global InfoInput_1
	global InfoInput_2
	global InfoInput_3
	GetRegistrationName = InfoInput_1.get()
	GetRegistrationPass = InfoInput_2.get()
	GetRegistrationConfirmPass = InfoInput_3.get()
	if len(GetRegistrationName) <= 1 or len(GetRegistrationPass) <= 1 or GetRegistrationPass != GetRegistrationConfirmPass:
		tkMessageBox.showerror("Error", "Invalid Credentials Entered")
	else:
		cursor.execute('''INSERT INTO Users(username, password) VALUES(?,?)''',(GetRegistrationName, GetRegistrationPass))
		db.commit()
		tkMessageBox.showinfo("Success", "Registration Successful")
		InfoInput_1.delete(0, END)
		InfoInput_1.insert(0, "")
		InfoInput_2.delete(0, END)
		InfoInput_2.insert(0, "")
		InfoInput_3.delete(0, END)
		InfoInput_3.insert(0, "")
		RegisterFrame.pack_forget()
		LoginFrame.pack()

def fromRegToLogPage():
	RegisterFrame.pack_forget()
	LoginFrame.pack()

def mainInterface():
	LoginFrame.pack_forget()
	MainInterfaceCusFrame.pack()

def LoginCredentials():
	global current
	global entry_1
	global entry_2
	global getLoginName
	global getLoginPassword;
	getLoginName = entry_1.get()
	getLoginPassword = entry_2.get()
	str(getLoginName)
	str(getLoginPassword)
	test = cursor.execute(''' SELECT loginPW FROM users WHERE loginID = ? ''', (getLoginName, )).fetchone()
	if test:
		checkPassword = test
		if getLoginPassword == checkPassword[0]:
			tkMessageBox.showinfo("Welcome", "Login Successful")
			time.sleep(0.5)
			mainInterface()
			entry_1.delete(0, END)
			entry_1.insert(0, "")
			entry_2.delete(0, END)
			entry_2.insert(0, "")
			
			userID = cursor.execute('SELECT userID FROM users WHERE loginID = ?', (getLoginName,)).fetchone()
			userName = cursor.execute('SELECT userName FROM users WHERE loginID = ?', (getLoginName,)).fetchone()
			userGender = cursor.execute('SELECT userGender FROM users WHERE loginID = ?', (getLoginName,)).fetchone()
			userContact = cursor.execute('SELECT userContact FROM users WHERE loginID = ?', (getLoginName,)).fetchone()
			userEmail = cursor.execute('SELECT userEmail FROM users WHERE loginID = ?', (getLoginName,)).fetchone()
			userAddress = cursor.execute('SELECT userAddress FROM users WHERE loginID = ?', (getLoginName,)).fetchone()
			userType = cursor.execute('SELECT userType FROM users WHERE loginID = ?', (getLoginName,)).fetchone()
			
			userID = userID[0]
			userName = userName[0]
			userGender = userGender[0]
			userContact = userContact[0]
			userEmail = userEmail[0]
			userAddress = userAddress[0]
			userType = userType[0]
			
			current = User(getLoginName, checkPassword, userID, userName, userGender, userContact, userEmail, userAddress, userType)
			
			LoginFrame.pack_forget()
			
			if userType == "Owner":
				owner()
			elif userType == "Customer":
				customer()
			else:
				admin()
			
		else:
			tkMessageBox.showerror("Error", "Wrong Password")
	else:
		tkMessageBox.showerror("Error", "User does not exist. Please register first.")

def onClickSearchHomestay():
	MainInterfaceCusFrame.pack_forget()
	SearchFrame.pack()


def onClickSearch():
	SearchFrame.pack_forget()
	SearchListFrame.pack()
	global SearchStateEntry
	global SearchCityEntry
	global SearchPriceMinEntry
	global SearchPriceMaxEntry
	global state
	global city
	global minPrice
	global maxPrice

	state = SearchStateEntry.get()
	city = SearchCityEntry.get()
	Label(SearchListFrame, text="Number").grid(row=0, column=0)
	Label(SearchListFrame, text="Address").grid(row=0, column=1)
	Label(SearchListFrame, text="City").grid(row=0, column=2)
	Label(SearchListFrame, text="State").grid(row=0, column=3)
	Label(SearchListFrame, text="Price").grid(row=0, column=4)
	Label(SearchListFrame, text="Description").grid(row=0, column=5)
	Label(SearchListFrame, text="Number of rooms").grid(row=0, column=6)
	Label(SearchListFrame, text="Number of bathrooms").grid(row=0, column=7)
	Label(SearchListFrame, text="Windows Available").grid(row=0, column=8)
	Label(SearchListFrame, text="Click to book").grid(row=0, column=9)

	minPrice = float(SearchPriceMinEntry.get())
	maxPrice = float(SearchPriceMaxEntry.get())
	cursor.execute(''' SELECT * FROM HOMESTAY ''')
	row = cursor.fetchall()
	rowC = 1
	columnC = 0
	for rows in row:
		isTrue = True
		if (state != rows[4] or city != rows[3]):
			if(state != ""):
				if(state != rows[4]):
					isTrue = False
			if(city != ""):
				if(city != rows[3]):
					isTrue = False
		elif(minPrice != 0):
			if(rows[5] < minPrice):
				isTrue = False
			elif(rows[5] > maxPrice):
				isTrue = False
		if(isTrue == True):
			print("true")
			loopcounter = 0
			Label(SearchListFrame, text=rowC).grid(row=rowC, column=columnC)
			columnC = columnC + 1
			Label(SearchListFrame, text=rows[2]).grid(row=rowC, column=columnC)
			columnC = columnC + 1
			Label(SearchListFrame, text=rows[3]).grid(row=rowC, column=columnC)
			columnC = columnC + 1
			Label(SearchListFrame, text=rows[4]).grid(row=rowC, column=columnC)
			columnC = columnC + 1
			Label(SearchListFrame, text=rows[5]).grid(row=rowC, column=columnC)
			columnC = columnC + 1
			Label(SearchListFrame, text=rows[6]).grid(row=rowC, column=columnC)
			columnC = columnC + 1
			Label(SearchListFrame, text=rows[7]).grid(row=rowC, column=columnC)
			columnC = columnC + 1
			Label(SearchListFrame, text=rows[8]).grid(row=rowC, column=columnC)
			columnC = columnC + 1
			Label(SearchListFrame, text=rows[9]).grid(row=rowC, column=columnC)
			columnC = columnC + 1
			Button(SearchListFrame, text="Book", fg="blue", command=lambda: bookfunc(rows[0])).grid(row=rowC, column=columnC)
			columnC = columnC + 1
			rowC = rowC + 1

		columnC = 0

def bookfunc(HOMEID):

	global currentHome
	global currentBook
		
	ownerID = cursor.execute('SELECT userID FROM homestay WHERE homeID = ?', (HOMEID,)).fetchone()
	homeAdd = cursor.execute('SELECT homeAddress FROM homestay WHERE homeID = ?', (HOMEID,)).fetchone()
	homeCity = cursor.execute('SELECT homeCity FROM homestay WHERE homeID = ?', (HOMEID,)).fetchone()
	homeState = cursor.execute('SELECT homeState FROM homestay WHERE homeID = ?', (HOMEID,)).fetchone()
	homePrice = cursor.execute('SELECT homePrice FROM homestay WHERE homeID = ?', (HOMEID,)).fetchone()
	homeDesc = cursor.execute('SELECT homeDesc FROM homestay WHERE homeID = ?', (HOMEID,)).fetchone()
	homeRoom = cursor.execute('SELECT roomAmount FROM homestay WHERE homeID = ?', (HOMEID,)).fetchone()
	homeBathroom = cursor.execute('SELECT bathroomAmount FROM homestay WHERE homeID = ?', (HOMEID,)).fetchone()
	homeWindows =  cursor.execute('SELECT hasWindows FROM homestay WHERE homeID = ?', (HOMEID,)).fetchone()
	
	ownerID = ownerID[0]
	homeAdd = homeAdd[0]
	homeCity = homeCity[0]
	homeState = homeState[0]
	homePrice = homePrice[0]
	homeDesc = homeDesc[0]
	homeRoom = homeRoom[0]
	homeBathroom = homeBathroom[0]
	homeWindows = homeWindows[0]
	
	
	#(address, city, state, price, desc, room, bathroom, window, id, hID = count+5001)
	currentHome = Homestay(homeAdd, homeCity, homeState, homePrice, homeDesc, homeRoom, homeBathroom, homeWindows, ownerID, HOMEID)
	
	#entry = (
	
	SearchListFrame.pack_forget()
	BookingFrame.pack()
	
def onClickListHomestay():
	MainInterfaceCusFrame.pack_forget()

def onClickUpdateUser():
	print()
	
def onClickDeleteUser():
	print()

def fromMaintoBook():
	MainInterfaceUserFrame.pack_forget()
	BookingFrame.pack()

def enterHomestay():
	global AddressEntry
	global CityEntry
	global StateEntry
	global PriceEntry
	global DescriptionEntry
	global RoomEntry
	global BathroomEntry
	global homeWindow
	
	address = AddressEntry.get()
	city = CityEntry.get()
	state = StateEntry.get()
	price = int(PriceEntry.get())
	desc = DescriptionEntry.get()
	room = int(RoomEntry.get())
	bathroom = int(BathroomEntry.get())
	window = homeWindow.get()

	id = IntVar()
	id = current.userID
	
	home = Homestay(address, city, state, price, desc, room, bathroom, window, id)
	
	entry = (home.homeID, id, home.homeAddress, home.homeCity, home.homeState, home.homePrice, home.homeDesc, home.roomAmount, home.bathroomAmount, home.hasWindows)
	
	db.commit()
	cursor.execute('INSERT INTO HOMESTAY VALUES (?,?,?,?,?,?,?,?,?,?)', entry)
	db.commit()
	
	tkMessageBox.showinfo("Homestay Entry", "Successfully entered!")
	HomestayEntryFrame.pack_forget()
	MainOwnerFrame.pack()
	
def selectPayment():
	selected = str(radio.get())
	if selected == "1" :
		displayPrice = Label(PaymentFrame, text="Price : $400").grid(row=4,column=0)

		pay = Button(PaymentFrame, text="Pay Now", fg="red", command=returnToMain).grid(row=8, column=0)
		
		displayCard = Label(PaymentFrame, text="Card Number").grid(row=5,column=0)
		enterCard = Entry(PaymentFrame).grid(row=5,column=1)

		displayExpiry = Label(PaymentFrame, text="Expire Date").grid(row=6,column=0)
		enterExpire = Entry(PaymentFrame).grid(row=6,column=1)		

		displayCVC = Label(PaymentFrame, text="CVC").grid(row=7,column=0)
		enterCVC = Entry(PaymentFrame)
		enterCVC.config(show='*')
		enterCVC.grid(row=7,column=1)
		
	else :
		pay = Button(PaymentFrame, text="Pay Now", fg="red", command=returnToMain).grid(row=8, column=0)



def paymentFrame():
	BookingFrame.pack_forget()
	PaymentFrame.pack()
	MakePayment = Label(PaymentFrame,text="Make Payment : ").grid(row=0,column=0)

	#showName = Label(PaymentFrame, text="Customer Name : " + str(getName.get())).grid(row=1,column=0)
	showStart = Label(PaymentFrame, text="Starting Booking Date : " + str(getStart.get())).grid(row=2,column=0)
	showEnd = Label(PaymentFrame, text="Booking End Date : " + str(getEnd.get())).grid(row=3,column=0)
	displayPrice = Label(PaymentFrame, text="Price : $400").grid(row=4,column=0)

	BookingPayment = Label(BookingFrame, text="Choose payment method: ")
	BookingPayment.grid(row=5,column=0)
	
	RDC = Radiobutton(PaymentFrame, text="Debit/Credit", variable=radio, value=1, command=selectPayment).grid(row=6,column=0)
	ROB = Radiobutton(PaymentFrame, text="Online Banking", variable=radio, value=2, command=selectPayment).grid(row=6,column=1)

def returnToLogin():
	MainInterfaceCusFrame.pack_forget()
	MainOwnerFrame.pack_forget()
	MainAdminFrame.pack_forget()
	LoginFrame.pack()

def returnToMain():

	tkMessageBox.showinfo("Payment","Your payment in successful!")

	#name = str(getName.get())
	periodStart = str(getStart.get())
	periodEnd = str(getEnd.get())
	price = "$400"


	#currenetBook = Booking(this, userID, homeID, bookingStart, bookingEnd, price, bookID=count+9001)
	currentBook = Booking(current.userID, currentHome.homeID, periodStart, periodEnd, price,)

	entry = (currentBook.bookID, currentBook.userID, currentBook.homeID, currentBook. bookingStart, currentBook.bookingEnd, currentBook.price)
	
	db.commit()
	cursor.execute('INSERT INTO booking VALUES (?,?,?,?,?,?)', entry)
	db.commit()
	
	
	PaymentFrame.pack_forget()
	MainInterfaceCusFrame.pack()



def customer():
	MainInterfaceCusFrame.pack()
	
	searchHomestayButton = Button(MainInterfaceCusFrame, text="Search Homestay", command=onClickSearchHomestay, bg="yellow", fg="black", activebackground="black", activeforeground="yellow", font=('Verdana',15))
	searchHomestayButton.pack(ipadx=9999, ipady=10)

	listHomestayButton = Button(MainInterfaceCusFrame, text="List Homestay", command=onClickListHomestay, bg="black", fg="yellow", activebackground="yellow", activeforeground="black", font=('Verdana',15))
	listHomestayButton.pack(ipadx=9999, ipady=10)

	makeBooking = Button(MainInterfaceCusFrame, text = "Make Booking", command = fromMaintoBook, bg = "yellow", fg = "black", activebackground = "black", activeforeground = "yellow", font=('Verdana',15))
	makeBooking.pack(ipadx=9999, ipady=10)
	
	reviewButt = Button(MainInterfaceCusFrame, text="Review", command=onClickReview, bg="black", fg="yellow", activebackground="yellow", activeforeground="black", font=('Verdana',15))
	reviewButt.pack(ipadx=9999, ipady=10)
	
	signOut = Button(MainInterfaceCusFrame, text="Sign Out", command=returnToLogin, bg="yellow", fg="black", activebackground="yellow", activeforeground="black", font=('Verdana',15))
	signOut.pack(ipadx=9999, ipady=10)


def owner():
	#MainOwnerFrame.pack_forget()
	MainOwnerFrame.pack()

	listOwnedHomestay = Button(MainOwnerFrame, text="Your Homestay", command=showHomestayList, bg="yellow", fg="black", activebackground="black", activeforeground="yellow", font=('Verdana',15))
	listOwnedHomestay.pack(ipadx=9999, ipady=10)

	regiHomestay = Button(MainOwnerFrame, text="Register Homestay", command=registerHomestay, bg="black", fg="yellow", activebackground="yellow", activeforeground="black", font=('Verdana',15))
	regiHomestay.pack(ipadx=9999, ipady=10)

	listBooking = Button(MainOwnerFrame, text="List of Booking Made", command=showBooking, bg="yellow", fg="black", activebackground="black", activeforeground="yellow", font=('Verdana',15))
	listBooking.pack(ipadx=9999, ipady=10)
	
	signOut = Button(MainOwnerFrame, text="Sign Out", command=returnToLogin, bg="black", fg="yellow", activebackground="yellow", activeforeground="black", font=('Verdana',15))
	signOut.pack(ipadx=9999, ipady=10)

def admin():
	MainAdminFrame.pack()
	
	listRegHomestay = Button(MainAdminFrame, text="Registered Homestay", command=showHomestay, bg="yellow", fg="black", activebackground="black", activeforeground="yellow", font=('Verdana',15))
	listRegHomestay.pack(ipadx=9999, ipady=10)

	adShoutOut = Button(MainAdminFrame, text="Advertisement", command=onClickAdvertisement, bg="black", fg="yellow", activebackground="yellow", activeforeground="black", font=('Verdana',15))
	adShoutOut.pack(ipadx=9999, ipady=10)

	manageUser = Button(MainAdminFrame, text="Manage Users", command=userManagement, bg = "yellow", fg = "black", activebackground = "black", activeforeground = "yellow", font=('Verdana',15))
	manageUser.pack(ipadx=9999, ipady=10)
	
	stats = Button(MainAdminFrame, text="Statistic", command=checkStats, bg = "black", fg="yellow", activebackground = "yellow", activeforeground="black", font=('Verdana',15))
	stats.pack(ipadx=9999, ipady=10)
	
	signOut = Button(MainAdminFrame, text="Sign Out", command=returnToLogin, bg="yellow", fg="black", activebackground="black", activeforeground="yellow", font=('Verdana',15))
	signOut.pack(ipadx=9999, ipady=10)
	
def checkStats():
	MainAdminFrame.pack_forget()

def showHomestayList():
	MainOwnerFrame.pack_forget()

def registerHomestay():
	MainOwnerFrame.pack_forget()
	HomestayEntryFrame.pack()

def showBooking():
	MainOwnerFrame.pack_forget()

def showHomestay():
	MainAdminFrame.pack_forget()

def onClickAdvertisement():
	MainAdminFrame.pack_forget()
	AdvertisementFrame.pack()

def userManagement():
	MainAdminFrame.pack_forget()

def onClickChooseFile():
	path = tkFileDialog.askopenfilename(initialdir = "/",title = "Select file",filetypes = (("image files","*.jpg *.png"),("all files","*.*")))
	
	img = ImageTk.PhotoImage(Image.open(path))
	
	print(path)
	
	imgFrame = Label(AdvertisementFrame, image=img)
	
	#label_1.pack_forget()
	AdvertisementFrame.pack_forget()
	imgFrame.pack(side = "bottom", fill = "both", expand = "yes")
	

#______________________________________________________________________________________________________________________________________________
#//////////////////////////////////////////////////////////////////// GUI \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
#______________________________________________________________________________________________________________________________________________

'''

'''

'''

'''

'''
BOOKING FRAME
'''

BookingDescriptionText = Label(BookingFrame, text="Booking Description: ")
BookingDescription = Label(BookingFrame, text="Description")
BookingDescriptionText.grid(row=1, column=0, sticky=E)
BookingDescription.grid(row=1, column=1, sticky=W)

BookingCustomer = Label(BookingFrame, text="Enter full name : ")
getName = Entry(BookingFrame)
BookingCustomer.grid(row=2, column=0, sticky=E)
getName.grid(row=2,column=1,sticky=E)

BookingPeriodStart = Label(BookingFrame, text="Enter starting date : ")
getStart = Entry(BookingFrame)
BookingPeriodStart.grid(row=3,column=0, sticky=E)
getStart.grid(row=3,column=1,sticky=E)

BookingPeriodEnd = Label(BookingFrame, text="Enter end date : ")
getEnd = Entry(BookingFrame)
BookingPeriodEnd.grid(row=4,column=0, sticky=E)
getEnd.grid(row=4,column=1, sticky=E)

BookNow = Button(BookingFrame, text="Book", fg="blue",command=paymentFrame)
BookNow.grid(row=9, columnspan=3)
'''
END BOOKING FRAME
'''	


'''
LOGIN FRAME
'''
label_1 = Label(LoginFrame, text="Username: ")
label_2 = Label(LoginFrame, text="Password: ")
entry_1 = Entry(LoginFrame)
entry_2 = Entry(LoginFrame)
entry_2.config(show='*')
entry_1.focus_set()
entry_2.focus_set()

label_1.grid(row=1, column=0, sticky=E)
label_2.grid(row=2, column=0, sticky=E)

entry_1.grid(row=1, column=1)
entry_2.grid(row=2, column=1)

LoginButton = Button(LoginFrame, text="Login", fg="blue", command=LoginCredentials)
LoginButton.grid(row=3,columnspan=2)

RegisterButton = Button(LoginFrame, text="Register", fg="blue", command=LoginRegisterClicked)
RegisterButton.grid(row=4,columnspan=2)
'''
END LOGIN FRAME
'''

'''
Register Frame
'''
Info_1 = Label(RegisterFrame, text="Username")
Info_2 = Label(RegisterFrame, text="Password")
Info_3 = Label(RegisterFrame, text="Confirm Password")
TextRegister = Button(RegisterFrame, text="Register", fg="blue", command=RegisterClicked)
TextRegister.grid(row=3, columnspan=2)
RegFrameBackLogin = Button(RegisterFrame,text="Go back to login", fg="blue", command=fromRegToLogPage)
RegFrameBackLogin.grid(row=4, columnspan=2)

InfoInput_1 = Entry(RegisterFrame)
InfoInput_2 = Entry(RegisterFrame)
InfoInput_3 = Entry(RegisterFrame)
InfoInput_2.config(show='*')
InfoInput_3.config(show='*')
InfoInput_1.focus_set()
InfoInput_2.focus_set()
InfoInput_3.focus_set()

Info_1.grid(row=0, column=0, sticky=E)
Info_2.grid(row=1, column=0, sticky=E)
Info_3.grid(row=2, column=0, sticky=E)

InfoInput_1.grid(row=0, column=1)
InfoInput_2.grid(row=1, column=1)
InfoInput_3.grid(row=2, column=1)
'''
END REGISTER FRAME
'''

'''
HOMESTAY ENTRY FRAME
'''

homeAddress = IntVar()
homeCity = IntVar()
homeState = IntVar()
homePrice = IntVar()
homeDescription = IntVar()
homeRoom = IntVar() 
homeBathroom = IntVar()
homeWindow = IntVar()

HomestayAddress = Label(HomestayEntryFrame, text="Address : ")
HomestayCity = Label(HomestayEntryFrame, text="City : ")
HomestayState = Label(HomestayEntryFrame, text="State : ")
HomestayPrice = Label(HomestayEntryFrame, text="Price per night : ")
HomestayDescription = Label(HomestayEntryFrame, text="Description : ")
HomestayRoom = Label(HomestayEntryFrame, text="Number of bedrooms : ")
HomestayBathroom = Label(HomestayEntryFrame, text="Number of bathrooms : ")
HomestayWindow = Label(HomestayEntryFrame, text="Does it have windows? : ")

AddressEntry = Entry(HomestayEntryFrame,width=50)
AddressEntry.focus_set()
CityEntry = Entry(HomestayEntryFrame)
CityEntry.focus_set()
StateEntry = Entry(HomestayEntryFrame)
StateEntry.focus_set()
DescriptionEntry = Entry(HomestayEntryFrame)
DescriptionEntry.focus_set()
PriceEntry = Entry(HomestayEntryFrame, textvariable=homePrice, width=8)
PriceEntry.focus_set()
RoomEntry = Entry(HomestayEntryFrame, textvariable=homeRoom, width=3)
RoomEntry.focus_set()
BathroomEntry = Entry(HomestayEntryFrame, textvariable=homeBathroom, width=3)
BathroomEntry.focus_set()
Checkbutton(HomestayEntryFrame, variable=homeWindow).grid(row=7, column = 1, sticky=W)

HomestayAddress.grid(row=0, column=0, sticky=E)
HomestayCity.grid(row=1, column=0, sticky=E)
HomestayState.grid(row=2, column=0, sticky=E)
HomestayPrice.grid(row=3, column=0, sticky=E)
HomestayDescription.grid(row=4, column=0, sticky=E)
HomestayRoom.grid(row=5, column=0, sticky=E)
HomestayBathroom.grid(row=6, column=0, sticky=E)
HomestayWindow.grid(row=7, column=0, sticky=E)

AddressEntry.grid(row=0, column=1, sticky=W)
CityEntry.grid(row=1, column=1, sticky=W)
StateEntry.grid(row=2, column=1, sticky=W)
DescriptionEntry.grid(row=4, column=1, sticky=W)
PriceEntry.grid(row=3, column=1, sticky=W)
RoomEntry.grid(row=5, column=1, sticky=W)
BathroomEntry.grid(row=6, column=1, sticky=W)


EntryButton = Button(HomestayEntryFrame,text="Publish Homestay", fg="blue", command=enterHomestay)
EntryButton.grid(row=9, columnspan=2)


'''
END HOMESTAY ENTRY FRAME
'''

'''
USER MANAGEMENT FRAME
'''

button_1 = Button(UserManagementFrame, text="Update/modify users", command=onClickUpdateUser, bg="red", fg="white", activebackground="white", activeforeground="red", font=('Verdana',15))
button_1.pack(ipadx=9999, ipady=10)

button_2 = Button(UserManagementFrame, text="Delete users", command=onClickDeleteUser, bg="blue", fg="white", activebackground="white", activeforeground="blue", font=('Verdana',15))
button_2.pack(ipadx=9999, ipady=10)

'''
END USER MANAGEMENT FRAME
'''

'''
UPDATE USER FRAME
'''

'''
END UPDATE USER FRAME
'''


'''
UPDATE USER FRAME
'''

'''
END UPDATE USER FRAME
'''

'''
ADVERTISEMENT FRAME
'''

label_1 = LabelFrame(AdvertisementFrame, width=700, height=200, highlightbackground="black")
button_1 = Button(AdvertisementFrame, text="Choose a file...", command=onClickChooseFile)

#label_1.grid(column=0, row=0)
button_1.grid(column=0, row=1)


#print(tkFileDialog.askopenfilename(initialdir = "/",title = "Select file",filetypes = (("image files","*.jpg *.png"),("all files","*.*"))))

'''
END ADVERTISEMENT FRAME
'''


'''
SEARCH FRAME
'''

Search = Label(SearchFrame, text="Search for your desired homestay", font=('Verdana',20))

SearchState = Label(SearchFrame, text="Enter State: ")
SearchCity = Label(SearchFrame, text="Enter City: ")
SearchPriceMin = Label(SearchFrame, text="Minimum Price: ")
SearchPriceMax = Label(SearchFrame, text="Maximum Price: ")
stateV = StringVar()
cityV = StringVar()
SearchStateEntry = Entry(SearchFrame, textvariable=stateV)
SearchStateEntry.focus_set()
SearchCityEntry = Entry(SearchFrame, textvariable=cityV)
SearchCityEntry.focus_set()
minV = IntVar()
maxV = IntVar()
SearchPriceMinEntry = Entry(SearchFrame, textvariable=minV)
SearchPriceMinEntry.focus_set()
SearchPriceMaxEntry = Entry(SearchFrame, textvariable=maxV)
SearchPriceMaxEntry.focus_set()

Search.grid(row=0, columnspan=2)

SearchState.grid(row=1, column=0, sticky=E)
SearchCity.grid(row=2, column=0, sticky=E)
SearchPriceMin.grid(row=3, column=0, sticky=E)
SearchPriceMax.grid(row=4, column=0, sticky=E)

SearchStateEntry.grid(row=1, column=1, sticky=W)
SearchCityEntry.grid(row=2, column=1, sticky=W)
SearchPriceMinEntry.grid(row=3, column=1, sticky=W)
SearchPriceMaxEntry.grid(row=4, column=1, sticky=W)

SearchButton = Button(SearchFrame, text="Search", fg="blue", command=onClickSearch)
SearchButton.grid(row=5, columnspan=2)


'''
END SEARCH FRAME
'''

'''
REVIEW FRAME
'''
ShowReviewButton = Button(ReviewFrame, text="Show Reviews", fg="black", command=onClickSReview)
ShowReviewButton.grid(row=3,columnspan=2,ipadx=20,ipady=10)

PostReviewButton = Button(ReviewFrame, text="Post a new Review?", fg="black", command=onClickPReview)
PostReviewButton.grid(row=6,columnspan=2,ipadx=20,ipady=10)

BackReviewButton = Button(ReviewFrame, text="Back to Main Menu", fg="black", command=onClickBReview)
BackReviewButton.grid(row=9,columnspan=2,ipadx=20,ipady=10)
'''
END REVIEW FRAME
'''

root.mainloop()