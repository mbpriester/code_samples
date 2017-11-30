require './student'
class StudentList
  @@student_list = []

  def read_load_comma
    File.open("comma.txt", "r") { |commaFile|
          commaFile.each_line{ |line|
        
          tempArray = line.split(',')
          
          temp = Student.new(tempArray[0].strip,tempArray[1].strip,tempArray[2].strip,Date.strptime(tempArray[4].strip, "%m/%d/%Y"),tempArray[3].strip)
          @@student_list.push(temp)
          }
    }
  end
  
  def read_load_dollar
    File.open("dollar.txt", "r") { |dollarFile|
              dollarFile.each_line{ |line|
            
              tempArray = line.split('$')
              
              temp = Student.new(tempArray[0].strip,tempArray[1].strip,tempArray[3].strip,Date.strptime(tempArray[4].strip, "%m-%d-%Y"),tempArray[5].strip)
              @@student_list.push(temp)
              }
        }
  end

  def read_load_pipe
    File.open("pipe.txt", "r") { |pipeFile|
              pipeFile.each_line{ |line|
            
              tempArray = line.split('|')
              
              temp = Student.new(tempArray[0].strip,tempArray[1].strip,tempArray[3].strip,Date.strptime(tempArray[5].strip, "%m-%d-%Y"),tempArray[4].strip)
              @@student_list.push(temp)
              }
        }
  end
  
  def load_all_files
    self.read_load_comma()
    self.read_load_dollar()
    self.read_load_pipe()
  end
  
  def display_list_by_campus
    campusArray = []
    lastNameArray = []
    displayArray = []
    campus_hash = Hash.new
    
    @@student_list.each() do|student| 
      key = student.campus + student.lastName
      campus_hash[key]= student
      campusArray.push(student.campus)
      lastNameArray.push(student.lastName)
    end
    campusArray.sort!
    campusArray.uniq!()
    lastNameArray.sort!
    
    campusArray.each() do|campus|
      lastNameArray.each() do|lastName| 
        key = campus+lastName
        displayArray.push(campus_hash[key].to_s)
      end
    end
    puts displayArray
  end
  
  def display_list_by_dob
    dob = []
    display_array = []
    dob_hash = Hash.new
    
    @@student_list.each() do|student|
      key = student.dateOfBirth
      dob.push(key)
      dob_hash[key] = student
    end
    
    dob.sort!()
    dob.each() do |dob|
      display_array.push(dob_hash[dob].to_s)
    end 
    puts display_array  
  end
  
  def display_list_by_last_name
    display_array = []
    last_name_array = []
    last_name_hash = Hash.new
    
    @@student_list.each() do|student|
      last_name_array.push(student.lastName)
      last_name_hash[student.lastName] = student
    end
    
    last_name_array.sort!().reverse!()
    
    last_name_array.each() do|lastName|
      display_array.push(last_name_hash[lastName].to_s)
    end
    
    puts display_array
    #order the students in descending order
  end
  
  def self.all 
    @@student_list=ObjectSpace.each_object(self).to_a
  end
  
  def self.all_count
    all.count
  end
end