class User:	
    def __init__(self, name, email):
        self.name = name
        self.email = email
        self.account_balance = 0

    # adding the deposit method
    def make_deposit(self, amount):	# takes an argument that is the amount of the deposit
        self.account_balance += amount
        return self

    # decrease the user's balance by the amount specified
    def make_withdrawal(self, amount):
        self.account_balance-=amount
        return self

    # have this method print the user's name and account balance to the terminal
    def display_user_balance(self) :
        print("User:",self.name+",","Balanxe:","$"+ str(self.account_balance))
        return self

    # this method decrease the user's balance by the amount and add that amount to other other_user's balance
    def transfer_money(self, other_user, amount):
        self.account_balance-=amount
        other_user.account_balance+=amount
        return self


#______________________________________________________________________
monty = User("Monty Python", "monty@python.com")
ali = User("Ali Argabi","alarqabi@gmail.com")
sarah = User ("Sarah","Sarah@gmail.com")
# ****** #
monty.make_deposit(50).make_deposit(51).make_deposit(52).make_withdrawal(40).display_user_balance()
ali.display_user_balance()
sarah.display_user_balance()


print("--------"*10)
monty.display_user_balance()
ali.make_deposit(77).make_deposit(77).make_withdrawal(5).make_withdrawal(7).display_user_balance()
sarah.display_user_balance()

sarah.make_deposit(100)
sarah.make_withdrawal(25)
sarah.make_withdrawal(40)
sarah.make_withdrawal(10)
print("--------"*10)
monty.display_user_balance()
ali.display_user_balance()
sarah.make_deposit(100).make_withdrawal(25).make_withdrawal(40).make_withdrawal(10).display_user_balance()

print("--------"*10)
monty.transfer_money(sarah,13)

monty.display_user_balance()
ali.display_user_balance()
sarah.display_user_balance()

