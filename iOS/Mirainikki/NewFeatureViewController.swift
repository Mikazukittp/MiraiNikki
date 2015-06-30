//
//  NewFeatureViewController.swift
//  Mirainikki
//
//  Created by 石部達也 on 2015/06/28.
//  Copyright (c) 2015年 石部達也. All rights reserved.
//

import UIKit

class NewFeatureViewController: UIViewController {

    @IBOutlet weak var pickerView: UIDatePicker!
    @IBOutlet weak var DateTextField: UITextField!
    
    var toolBar:UIToolbar!
    var myDatePicker: UIDatePicker!
    
    
    
    @IBAction func TextFieldTaped(sender: AnyObject) {
        
        self.pickerView.hidden = true;
    }
   
    
    
    
}
