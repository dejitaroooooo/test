using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class BackGroundController : MonoBehaviour {
	
	// Update is called once per frame
	void Update () {
        transform.Translate(0, -0.3f, 0);
        if(transform.position.y < -4.9f)
        {
            transform.position = new Vector3(0, 4.9f, 0);
        }
	}
}
