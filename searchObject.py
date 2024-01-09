def display(array):
    print(array)
    
def search(array,criteria):
    newarray=[]
    for obj in array:
        if(criteria(obj)):
            newarray.append(obj)
    return newarray

def check_string_starts_with_any(sub_str):
    predicate = lambda main_str : main_str.startswith(sub_str)
    return predicate

array = ["hello","HI","WelComE","to","ZEISS"]
newarray = search(array,check_string_starts_with_any('t'))
display(newarray)
