def display(array):
    print(array)
    
def search(array,criteria):
    newarray=[]
    for obj in array:
        if(criteria(obj)):
            newarray.append(obj)
    return newarray

def isStringUpper(obj):
    if(obj.isupper()):
        return True
    else:
        return False

array = ["hello","HI","WelComE","to","ZEISS"]
newarray = search(array,isStringUpper)
display(newarray)
