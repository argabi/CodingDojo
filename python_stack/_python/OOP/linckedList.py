class SNode:
    def __init__(self, value):
        self.value = value
        self.next = None


class SList:
    def __init__(self):
        self.head = None
    
     	def add_to_front(self, val):
            new_node = SLNode(val)
            current_head = self.head
            new_node.next = current_head
            self.head = new_node	# SET the list's head TO the node we created in the last step
            return self	                # return self to allow for chaining


#______________________________________________________________________________________________________
my_list = SList()