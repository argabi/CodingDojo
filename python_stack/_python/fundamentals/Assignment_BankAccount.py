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
acount1 = BankAccount(1500,0.02)
acount2 = BankAccount(3000)

acount1.display_account_info()
acount2.display_account_info()
#_________________________________________
print("-------"*9)
acount1.deposit(300).deposit(200).deposit(100).withdraw(100).yield_interest().display_account_info()
#_________________________________________
print("-------"*9)
acount2.deposit(1000).deposit(500).withdraw(100).withdraw(50).withdraw(150).withdraw(200).yield_interest().display_account_info()