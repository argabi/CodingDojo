class BankAccount:
    def __init__(self,  balance=0.00 ,int_rate=0.01): # don't forget to add some default values for these parameters!
        self.accountBalance = balance
        self.accountInterestRate =int_rate
    
    # increases the account balance by the given amount
    def deposit(self, amount):
        self.accountBalance += amount
        return self
   
   # decreases the account balance by the given amount if there are sufficient funds; if there is not enough money, print a message "Insufficient funds: Charging a $5 fee" and deduct $5
    def withdraw(self, amount):
        if self.accountBalance <=0:
            print("Insufficient funds: Charging a $5 fee")
            self.accountBalance -=5
        self.accountBalance -= amount
        return self
   
    # print to the console: eg. "Balance: $100"
    def display_account_info(self):
        print("Balance:","$"+ str(self.accountBalance))
        return self
   
    # increases the account balance by the current balance * the interest rate (as long as the balance is positive)
    def yield_interest(self):
        if self.accountBalance >0 :
            self.accountBalance += (self.accountBalance * self.accountInterestRate)
        return self

# ****************************************************************************************************************
  

class User:
    def __init__(self, name, email):
        self.name = name
        self.email = email
        self.account = BankAccount( balance=0.00 ,int_rate=0.02)	# added this line

    def make_deposit(self,amount):
        self.account.deposit(amount)
        return self

    def make_withdrawal(self,amount):
        self.account.withdraw(amount)
        return self

    def display_user_balance(self):
        print("User:",self.name, "Balance:", "$" + str(self.account.accountBalance)	)	# or access its attributes
        return self


# ****************************************************************************************************************
aqil = User("Aqil", "Aqil@gmail.com")
ali = User("Ali Argabi", "alargabi@gmail.com")

ali.make_withdrawal(1000)
ali.make_deposit(3000)
ali.display_user_balance()

aqil.display_user_balance()