require 'date'
require 'time'

class Student
  attr_accessor :lastName, :firstName, :faveColor, :dateOfBirth, :campus
  def initialize(ln, fn, campus, dob, faveColor)
    @lastName, @firstName, @campus, @dateOfBirth, @faveColor = ln, fn, campus, dob, faveColor
  end

  def to_s
    puts @lastName+" "+@firstName+" "+@campus+" "+@dateOfBirth.strftime("%-m/%-d/%Y")+" "+@faveColor
  end
end