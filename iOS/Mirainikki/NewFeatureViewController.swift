//
//  NewFeatureViewController.swift
//  Mirainikki
//
//  Created by 石部達也 on 2015/06/28.
//  Copyright (c) 2015年 石部達也. All rights reserved.
//

import UIKit

class NewFeatureViewController:UIViewController,UITextFieldDelegate{
    
    @IBOutlet weak var InputText: UITextView!

    override func viewDidLoad() {
        super.viewDidLoad()
    
        InputText.text = "aaa"        // Do any additional setup after loading the view.
    }
}
