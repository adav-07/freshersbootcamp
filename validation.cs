using System;
using System.Collections.Generic;
class Device
{
    private string id, description;
    int code;

    // [Required(ErrorMessage="ID Property Requires Value")]


    public string Id
    {
        get
        {
            return id;
        }
        set
        {
            if (string.IsNullOrEmpty(value))
            {
                throw new ArgumentException("ID Property Requires Value");
            }
            id = value;
        }
    }
    //   [Range(10,100,"Code Value Must Be Within 10-100")]
    public int Code
    {
        get
        {
            return code;
        }
        set
        {
            if (value < 10 || value > 100)
            {
                throw new ArgumentException("Code Value Must Be Within 10-100");
            }
            code = value;
        }
    }

    //   [MaxLength(100,"Max of 100 Charcters are allowed")]
    public string Description
    {
        get
        {
            return description;
        }
        set
        {
            if (value != null && value.Length > 100)
            {
                throw new ArgumentException("Max of 100 Characters are allowed");
            }
            description = value;
        }
    }

}

class ObjectValidator
{
    public static bool Validate(Device deviceObject, out List<string> errorlist)
    {
        errorlist = new List<string>();
        try
        {
            deviceObject.Code = 1;
            deviceObject.Id = "127198";
            deviceObject.Description = "Description";
        }
        catch (ArgumentException ex)
        {
            errorlist.Add(ex.Message);
        }
        return errorlist.Count == 0;
    }
}

public class HelloWorld
{
    static void Main()
    {
        Device deviceObj = new Device();
        
        List<string> errors;
        bool isValid = ObjectValidator.Validate(deviceObj, out errors);
        if (!isValid)
        {
            foreach (string item in errors)
            {
                System.Console.WriteLine(item);

            }
        }
        else
        {
            System.Console.WriteLine("Valid Device Object");
        }
    }
}
